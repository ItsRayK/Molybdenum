package entities;

import java.util.ArrayList;

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

	public void removeContents() {
		// contents = null;
		empty = true;
	}

	public Square fillSquare(Letter l) {
		contents = l;
		return this;
	}

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

	public void setActivity(boolean tf) {
		active = tf;
	}
	
	public boolean getEmpty(){
		return empty;
	}

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

	public boolean isSameSquare(Square s) {
		if (this.column == s.column && this.row == s.row)
			return true;
		else
			return false;
	}

	public boolean isAlreadyInList(ArrayList<Square> squares) {
		return squares.iterator().next().isSameSquare(this);
	}

	public boolean isEmptyAndActive() {
		if (empty && isActive())
			return true;
		else
			return false;
	}

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
