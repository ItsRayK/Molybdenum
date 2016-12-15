package entities;

import java.util.ArrayList;

/**
 * The Entities class for the square.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class Square {
	Letter contents;
	int row;
	int column;
	public boolean active = false;
	public boolean empty = false;

	public Square(int row, int column, boolean active) {
		this.row = row;
		this.column = column;
		this.active = active;

	}

	/**
	 * Changes the empty flag of a full square to true
	 */
	public void removeContents() {
		// contents = null;
		empty = true;
	}

	/**
	 * Fill a square with the letter l.
	 * 
	 * @param l
	 * @return
	 */

	public Square fillSquare(Letter l) {
		contents = l;
		return this;
	}

	/**
	 * Fill a square with a random letter.
	 */
	public void fillSquareWithRandom() {
		Letter l = new Letter();
		l.randomLetter();
		setContents(l);
	}

	/**
	 * Returns the contents of a square as a string if filled or as null if
	 * empty
	 **/
	public String getContentsString() {
		if (contents == null) {
			return null;
		} // AWKWARD
		return contents.letterString;
	}

	public int getContentsPoints() {
		return contents.value;
	}

	public boolean isActive() {
		return active;
	}

	/**
	 * Sets if a square is active or not in the board with the parameter tf.
	 * 
	 * @param tf
	 */
	public void setActivity(boolean tf) {
		active = tf;
	}

	public boolean getEmpty() {
		return empty;
	}

	/**
	 * This function determines if a square s is adjacent to this square. This
	 * is used to see if a clicked letter is valid to make a word with.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isAdjacentTo(Square s) {
		if (this.column == s.column) {
			if (this.row == (s.row + 1)) {
				return true;
			} else if (this.row == (s.row - 1)) {
				return true;
			} else {
				return false;
			}
		} else if (this.row == s.row) {
			if (this.column == (s.column + 1)) {
				return true;
			} else if (this.column == (s.column - 1)) {
				return true;
			} else {
				return false;
			}
		} else if (this.column == (s.column - 1)) {
			if (this.row == (s.row + 1)) {
				return true;
			} else if (this.row == (s.row - 1)) {
				return true;
			} else {
				return false;
			}
		} else if (this.column == (s.column + 1)) {
			if (this.row == (s.row + 1)) {
				return true;
			} else if (this.row == (s.row - 1)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	/**
	 * This determines if two squares are in the same spot coloumnwise and
	 * rowwise.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isSameSquare(Square s) {
		if (this.column == s.column && this.row == s.row)
			return true;
		else
			return false;
	}

	/**
	 * This sees if a square is already in a list of squares. This is used to
	 * determine if you can't deselect a square on the board if it is not
	 * adjacent.
	 * 
	 * @param squares
	 * @return
	 */
	public boolean isAlreadyInList(ArrayList<Square> squares) {
		return squares.iterator().next().isSameSquare(this);
	}

	/**
	 * This returns true if a square's empty flag is true and it is also an
	 * active square.
	 * 
	 * @return
	 */
	public boolean isEmptyAndActive() {
		if (empty && isActive())
			return true;
		else
			return false;
	}

	/**
	 * This returns true if a square is active and there is a letter in it.
	 * 
	 * @return
	 */
	public boolean notEmptyActive() {
		if (contents != null && isActive())
			return true;
		else
			return false;
	}

	public Letter getContents() {
		return contents;
	}

	public void setContents(Letter contents) {
		this.contents = contents;
		empty = false;
	}
}
