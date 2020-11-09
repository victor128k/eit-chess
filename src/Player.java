import java.util.ArrayList;

public class Player {
	
	private Color color;
	private static final int WHITE_PAWNS_ROW = 6;
	private static final int WHITE_FIGURES_ROW = 7;
	private static final int BLACK_PAWNS_ROW = 2;
	private static final int BLACK_FIGURES_ROW = 1;
	
	ArrayList<Chessman> chessmen = new ArrayList<Chessman>();
	

	public Player(int i) {
		if (i == 0) {
			color = Color.WHITE;
		}
		else if (i == 1)
		{
			this.color = Color.BLACK;
		}
		this.initializeChessmen();
	}
	
	private void initializeChessmen() {
		for (int column = 0; column < 8; column++) {
			chessmen.add(new Pawn(new ChessCoordinate(this.getPawnsRow(), column)));
		}
		chessmen.add(new Rook(new ChessCoordinate(this.getFiguresRow(), 'a')));
		chessmen.add(new Knight(new ChessCoordinate(this.getFiguresRow(), 'b')));
		chessmen.add(new Bishop(new ChessCoordinate(this.getFiguresRow(), 'c')));
		chessmen.add(new Queen(new ChessCoordinate(this.getFiguresRow(), 'd')));
		chessmen.add(new King(new ChessCoordinate(this.getFiguresRow(), 'e')));
		chessmen.add(new Bishop(new ChessCoordinate(this.getFiguresRow(), 'f')));
		chessmen.add(new Knight(new ChessCoordinate(this.getFiguresRow(), 'g')));
		chessmen.add(new Rook(new ChessCoordinate(this.getFiguresRow(), 'h')));
	}
	
	private int getPawnsRow() {
		if (this.color == Color.WHITE) {
			return Player.WHITE_PAWNS_ROW;
		}
		return Player.BLACK_PAWNS_ROW;
	}
	
	private int getFiguresRow() {
		if (this.color == Color.WHITE) {
			return Player.WHITE_FIGURES_ROW;
		}
		return Player.BLACK_FIGURES_ROW;
	}

	public boolean hasChessmanIn(ChessCoordinate coordinate) {
		int i = 0;
		while (i < this.chessmen.size() - 1 && !this.chessmen.get(i).getCoordinate().equals(coordinate))
		{
			i++;
		}
		return this.chessmen.get(i).getCoordinate().equals(coordinate);
	}

	public char getLetterOfChessmanIn(ChessCoordinate coordinate) {
		return this.getChessmanIn(coordinate).getLetter(this.color);
	}
	
	private Chessman getChessmanIn(ChessCoordinate coordinate) {
		int i = 0;
		while (i < this.chessmen.size() && !this.chessmen.get(i).getCoordinate().equals(coordinate))
		{
			i++;
		}
		return this.chessmen.get(i);
	}

}
