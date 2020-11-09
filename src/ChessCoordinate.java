public class ChessCoordinate {

	private int row;
	private int column;

	public ChessCoordinate(int rowNumber, char columnLetter) {
		this.row = 8 - rowNumber;
		switch (columnLetter) {
			case 'a': this.column = 0; break;
			case 'b': this.column = 1; break;
			case 'c': this.column = 2; break;
			case 'd': this.column = 3; break;
			case 'e': this.column = 4; break;
			case 'f': this.column = 5; break;
			case 'g': this.column = 6; break;
			case 'h': this.column = 7; break;
		}
	}

	public ChessCoordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public boolean equals(ChessCoordinate coordinate) {
		return this.row == coordinate.row && this.column == coordinate.column;
	}

}
