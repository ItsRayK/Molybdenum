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
	int savedStars[];

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
				updateSavedStars();
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

	public void updateSavedStars() throws IOException {
		int scoreLineNum = Integer.parseInt(level.getLevelName().replace("Level ", ""));
		String path = "src/SavedStars.txt";
		File file = new File(path);
	//	InputStream fis = new FileInputStream(file);
	
		savedStars = new int[15];
		for (int i = 0; i < 15; i++) {
			int readCheck = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(i));
			savedStars[i] = readCheck;
			
			if(scoreLineNum-1 == i){
				int starsFilled;
				if (level.getCurrScore().isStar3Filled()) {
					starsFilled = 3;
					savedStars[i] = starsFilled;

				} else if (level.getCurrScore().isStar2Filled()) {
					starsFilled = 2;
					if (starsFilled >= savedStars[i]) {
						savedStars[i] = starsFilled;
					}

				} else if (level.getCurrScore().isStar1Filled()) {
					starsFilled = 1;
					if (starsFilled >= savedStars[i]) {
						savedStars[i] = starsFilled;
					}
				}
			}
		}

		bw = new BufferedWriter(new FileWriter("src/SavedStars.txt", false));
		for (int i = 0; i < 15; i++) {
			
			bw.write("" + savedStars[i]);
			bw.newLine();
			bw.flush();
		}


	}
}
