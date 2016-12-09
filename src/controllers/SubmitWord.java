package controllers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import entities.*;
import player.PuzzleView;

public class SubmitWord {
	Word word;
	Puzzle level;
	PuzzleView view;
	BufferedWriter bw;

	public SubmitWord(PuzzleView pV, Puzzle p, Word currentWord) {
		view = pV;
		level = p;
		word = currentWord;
	}

	public boolean submit() throws Exception {
		String wordFound = word.getWordString();
		File file = new File("src/WordTable.sort");
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
				level.subtractWordsLeft();
				view.addToWordsFound(wordFound);
				view.updateStars();
				view.unselectBoardSquares();
				level.getLettersSelected().clear();
				level.getBoard().floatUp();
				level.fillEmptyWithRandomLetters();
				for (int i = 0; i <= 5; i++) {
					for (int j = 0; j <= 5; j++) {
						if (level.getBoard().squares[i][j].isActive()) {
							view.getBoardSquares()[i][j].setText("<html><b>"
									+ level.getBoard().squares[i][j].getContentsString() + "</b><font size = '3'><sub>"
									+ level.getBoard().squares[i][j].getContentsPoints() + "</sub></font></html>");
						}
					}
				}
				
				return true;
			}

		}
		if (line.equals("endofdocument")) {
			System.out.println("Word does not exists");
			view.unselectBoardSquares();
			level.getLettersSelected().clear();
			return false;
		}
		return false;

	}

}
