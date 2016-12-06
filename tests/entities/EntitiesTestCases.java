package entities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EntitiesTestCases {

	@Test
	public void testWord() {
		Square s = new Square(0, 0, true);
		Letter l = new Letter();
		l.randomLetter();
		s.fillSquare(l);

		ArrayList<Square> testList = new ArrayList<Square>();
		testList.add(s);

		Word test = new Word(testList);

		System.out.println(test.getWordString());

		assertEquals(l.getString(), test.getWordString());

	}

	@Test
	public void testMakeAndUnmakeWord() {
		Square s = new Square(0, 0, true);
		Letter l = new Letter();
		l.randomLetter();
		s.fillSquare(l);

		Square s2 = new Square(0, 0, true);
		Letter l2 = new Letter();
		l2.setLetter("T", 1);
		s2.fillSquare(l2);

		Square s3 = new Square(0, 0, true);
		Letter l3 = new Letter();
		l3.randomLetter();
		s3.fillSquare(l3);

		ArrayList<Square> testList = new ArrayList<Square>();
		testList.add(s);

		Word test = new Word(testList);

		test.makeWord(s2);
		test.makeWord(s3);

		System.out.println(test.getWordString());
		
		assertEquals(l.getString().concat(l2.getString()).concat(l3.getString()), test.getWordString());
		
		test.unMakeWord();
		
		assertEquals(l.getString().concat(l2.getString()), test.getWordString());

		
	}
	public void TestSquareActivation(){
		Board testBoard = new Board();
		for(int i=0; i<5; i++){
			for(int j= 0; j<5; j++){
				testBoard.activateSquare(i, j);
			}
		}
		for(int i=0; i<5; i++){
			for(int j= 0; j<5; j++){
				assertEquals(testBoard.squares[i][j].isActive(),true);
			}
		}
		for(int i=0; i<5; i++){
			for(int j= 0; j<5; j++){
				testBoard.deActivateSquare(i, j);
			}
		}
		for(int i=0; i<5; i++){
			for(int j= 0; j<5; j++){
				assertEquals(testBoard.squares[i][j].isActive(),false);
			}
		}
		testBoard.deActivateSquare(2, -3);
	}

}
