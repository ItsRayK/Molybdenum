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
		for (int i = 0; i < 6; i++) {
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
		assertEquals("A", b.getSquare(0, 0).getContentsString());
		assertEquals("E", b.getSquare(0, 2).getContentsString());

		// remove from board
		Puzzle p = new Puzzle("test", b);
		p.currentWord = w;
		p.submitWord();

		// validate empty
		assertTrue(b.getSquare(0, 0).isEmptyAndActive());

		// separate submitWord from "float up" concept
		// now get the FLOAT to work.
		b.floatUp();

		assertEquals("C", b.getSquare(0, 0).getContentsString());
		assertFalse(b.getSquare(0, 5).isEmptyAndActive());

		b.getSquare(0, 5).fillSquareWithRandom();
		assertTrue(!b.getSquare(0, 5).isEmptyAndActive());
	}
	
	public void testEmptySquares(){
		Board b = new Board();
		
		Square[][] active = b.activeSquares();
		
		b.fillEmptyActiveSquares();
		
		b.deActivateSquare(1, 2);
		b.activateSquare(1, 2);
		
		active[1][2].removeContents();
		assertTrue(active[1][2].isEmptyAndActive());
		
		active[2][1].removeContents();
		assertTrue(b.isNextAboveSquareEmpty(active[2][2]));
	}
	
	public void testClearAndFill(){ //Testing random letter in letter class
		Board b  = new Board();
		
		b.clearAllActiveSquares();
		
		b.fillEmptyActiveSquares();
	}
}
