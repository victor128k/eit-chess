
public class Chessman {
	
	protected char letter;
	protected ChessCoordinate coordinate;
	
	public Chessman(ChessCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public char getLetter(Color color) {
		if (color == Color.WHITE) {
			return Character.toUpperCase(this.letter);
		}
		return Character.toLowerCase(this.letter);
	}

	public ChessCoordinate getCoordinate() {
		return this.coordinate;
	}

}
