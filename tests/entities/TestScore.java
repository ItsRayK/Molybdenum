package entities;

import junit.framework.TestCase;

public class TestScore extends TestCase {
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

	}
}

