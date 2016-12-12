package controllers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import entities.*;
import player.ThemeView;

public class SubmitWordTheme {
	Word word;
	Theme level;
	ThemeView view;
	BufferedWriter bw;

	public SubmitWordTheme(ThemeView pV, Theme p, Word currentWord) {
		view = pV;
		level = p;
		word = currentWord;
	}

	public boolean submit() throws Exception {
		String wordFound = word.getWordString();
		File file = new File("savedLevels/" + level.getLevelName() + ".txt");
		InputStream fis = new FileInputStream(file);

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		// now read the file line by line...
		int lineNum = 0;
		String line;
		while (!(line = br.readLine().replaceAll("\\s+", "")).equals("endofdocument")) {

			lineNum++;
			if (wordFound.length() < 3) {
				System.out.println("Word is too short!");
				level.getLettersSelected().clear();
				view.unselectBoardSquares();
				return false;
			} else if (line.equalsIgnoreCase(wordFound)) {
				System.out.println(wordFound + " is on line " + lineNum);

				level.submitWord();

				wordFound = level.getCurrentWord().getWordString();
				view.addToWordsFound(wordFound);
				view.updateStars();
				view.unselectBoardSquares();
				level.getLettersSelected().clear();
				level.getBoard().floatUpTheme();
				level.getCurrentWord().setWordString();

				for (int i = 0; i <= 5; i++) {
					for (int j = 0; j <= 5; j++) {
						if (level.getBoard().squares[i][j].isActive()) {
							if (level.getBoard().squares[i][j].isEmpty())
								view.getBoardSquares()[i][j].setVisible(false);
							view.getBoardSquares()[i][j].setText("<html><b>"
									+ level.getBoard().squares[i][j].getContentsString() + "</font></html>");

						}
					}
				}

				return true;
			}

		}
		if (line.equals("endofdocument")) {
			System.out.println("Word is not part of the theme.");
			view.unselectBoardSquares();
			level.getLettersSelected().clear();
			return false;
		}
		return false;

	}

}
