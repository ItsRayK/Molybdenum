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

}
