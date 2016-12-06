package entities;

public class Square {
	Letter contents;
	int row;
	int column;
	public boolean active = false;

	public Square(int row, int column, boolean active) {
		this.row = row;
		this.column = column;
		this.active = active;

	}

	public void removeContents() {
		contents = null;
	}

	public Square fillSquare(Letter l) {
		contents = l;
		return this;
	}

	public String getContentsString() {
		if (contents == null) { return null; } // AWKWARD
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
}
