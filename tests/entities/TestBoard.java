package entities;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	public void testStart() {
		// start with sample 6x6 
		Board b = new Board();
		
		// someone needs to do random letter assignment.
		Square[][] active = b.activeSquares();
		
		String init = "ACEACECAFCAFXRDXRDYZYYZYAAAAAAAAAAAA";
		int idx = 0;
		for (int i = 0; i < 6 ; i++ ) {
			for (int j = 0; j < 6; j++) {
				active[i][j].fillSquare(new Letter(init.charAt(idx), 1));
				idx++;
			}
		}
		
		// form WORD
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(active[0][0]);
		squares.add(active[1][0]);
		squares.add(active[2][0]);
		
		Word w = new Word(squares);
		
		// validate letters are in place
		assertEquals ("A", b.getSquare(0, 0).getContentsString());
		assertEquals ("E", b.getSquare(2, 0).getContentsString());
		
		// remove from board
		Puzzle p = new Puzzle ("test", b);
		p.currentWord = w;
		p.submitWord();
		
		// validate empty
		assertTrue(b.getSquare(0, 0).getContentsString() == null);
		
		// separate submitWord from "float up" concept
		// now get the FLOAT to work.
		b.floatUp();
		
		assertEquals ("C", b.getSquare(0, 0).getContentsString());
		assertTrue(b.getSquare(0, 5).getContentsString() == null);
		//b.fillEmptyWithRandomLetters();
		
		assertTrue(b.getSquare(0, 5).getContentsString() != null);
	}
}
