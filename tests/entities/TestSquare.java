package entities;

import junit.framework.TestCase;

public class TestSquare extends TestCase {
	
	public void test() {
		Square s = new Square (2, 2, true);
		
		assertTrue (s.isActive());
		Letter letter = new Letter();
		letter.setLetter("A", 2);
		s.fillSquare(letter);
		
		assertEquals ("A", s.getContentsString());
		
		s.removeContents();
		
		assertTrue (s.getContentsString() == null);   // AWKWARD
	}
	
	public void testRandom() {
		Square s = new Square (0, 0, true);
		s.fillSquareWithRandom();
		assertTrue (s.notEmptyActive());
		
		s.setActivity(false);
		assertFalse(s.notEmptyActive());
		
		s.setActivity(true);
		
		Square s2 = new Square (0, 0, true);
		assertTrue(s.isSameSquare(s2));
		
		Square s3 = new Square (0, 2, true);
		assertFalse(s.isSameSquare(s3));
	}
	
	public void testAdjacent() {
		Square s = new Square (2, 2, true);
		Square s2 = new Square (2, 1, true);
		Square s3 = new Square (1, 2, true);
		Square s4 = new Square (1, 1, true);
		Square s5 = new Square (3, 3, true);
		Square s6 = new Square (3, 2, true);
		Square s7 = new Square (3, 1, true);
		Square s8 = new Square (2, 3, true);
		Square s9 = new Square (1, 3, true);
		
		assertTrue(s.isAdjacentTo(s2));
		assertTrue(s.isAdjacentTo(s3));
		assertTrue(s.isAdjacentTo(s4));
		assertTrue(s.isAdjacentTo(s5));
		assertTrue(s.isAdjacentTo(s6));
		assertTrue(s.isAdjacentTo(s7));
		assertTrue(s.isAdjacentTo(s8));
		assertTrue(s.isAdjacentTo(s9));
		
		
	}

}
