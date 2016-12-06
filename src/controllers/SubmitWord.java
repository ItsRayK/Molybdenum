package controllers;

import java.io.*;
import java.util.*;

import entities.*;
import player.PuzzleView;

public class SubmitWord {
	Word word;
	Puzzle level;
	PuzzleView view;

	public SubmitWord(PuzzleView pV, Puzzle p, Word currentWord) {
		view = pV;
		level = p;
		word = currentWord;
	}

	public void submit() throws Exception {
		String wordFound = word.getWordString();
		File file = new File("src/WordTable.sort");
		InputStream fis = new FileInputStream(file);

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		// now read the file line by line...
		int lineNum = 0;
		String line;
		while (!(line = br.readLine().replaceAll("\\s+", "")).equals("endofdocument")) {

			lineNum++;
			if (line.equalsIgnoreCase(wordFound)) {
				System.out.println(wordFound + " is on line " + lineNum);
				level.submitWord();
				view.addToWordsFound(wordFound);
				level.getLettersSelected().clear();

				break;
			} else {
				if (line.equals("endofdocument")) {
					System.out.println("Word does not exists");
					level.getLettersSelected().clear();
				}
			}

		}
		
	}

}