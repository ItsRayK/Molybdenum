package entities;

public class Square {
	Letter contents;
	int row;
	int column;
	boolean active;

	public void removeSquare(Square s) {
		contents = null;
	}

	public Square fillSquare(Letter l) {
		contents = l;
		return this;
	}

	public String getContentsString() {
		return contents.letterString;
	}

	public int getContentsPoints() {
		return contents.value;
	}

	public boolean isActive() {
		if (contents != null)
			return true;
		else
			return false;
	}

	public void setActivity(boolean tf) {
		active = tf;
	}
}
