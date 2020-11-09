import java.util.ArrayList;

public class Player {
	
	private Color color;
	// TODO dar una vuelta a cómo arreglar este cisco...
	//  modificar para: internamente usar las coordenadas del array del tablero siempre (0,0) .. (7,7)
	//  solo al intereactuar con el usuario y pintar, mostrar y leer las coordenadas del ajedrez (a1 .. h8)
	private static final int WHITE_PAWNS_ROW = 6;
	private static final int WHITE_PAWNS_CHESSROW = 2;
	private static final int WHITE_FIGURES_ROW = 7;
	private static final int WHITE_FIGURES_CHESSROW = 1;
	private static final int BLACK_PAWNS_ROW = 1;
	private static final int BLACK_PAWNS_CHESSROW = 7;
	private static final int BLACK_FIGURES_ROW = 0;
	private static final int BLACK_FIGURES_CHESSROW = 8;
	
	ArrayList<Chessman> chessmen = new ArrayList<Chessman>();
	

	public Player(int i) {
		if (i == 0) {
			this.color = Color.WHITE;
		}
		else if (i == 1)
		{
			this.color = Color.BLACK;
		}
		this.initializeChessmen();
	}
	
	private void initializeChessmen() {
		for (int column = 0; column < 8; column++) {
			this.chessmen.add(new Pawn(new ChessCoordinate(this.getPawnsRow(), column)));
		}
		this.chessmen.add(new Rook(new ChessCoordinate(this.getFiguresChessRow(), 'a')));
		this.chessmen.add(new Knight(new ChessCoordinate(this.getFiguresChessRow(), 'b')));
		this.chessmen.add(new Bishop(new ChessCoordinate(this.getFiguresChessRow(), 'c')));
		this.chessmen.add(new Queen(new ChessCoordinate(this.getFiguresChessRow(), 'd')));
		this.chessmen.add(new King(new ChessCoordinate(this.getFiguresChessRow(), 'e')));
		this.chessmen.add(new Bishop(new ChessCoordinate(this.getFiguresChessRow(), 'f')));
		this.chessmen.add(new Knight(new ChessCoordinate(this.getFiguresChessRow(), 'g')));
		this.chessmen.add(new Rook(new ChessCoordinate(this.getFiguresChessRow(), 'h')));
	}
	
	private int getPawnsRow() {
		if (this.color == Color.WHITE) {
			return Player.WHITE_PAWNS_ROW;
		}
		return Player.BLACK_PAWNS_ROW;
	}
	private int getPawnsChessRow() {
		if (this.color == Color.WHITE) {
			return Player.WHITE_PAWNS_ROW;
		}
		return Player.BLACK_PAWNS_CHESSROW;
	}
	
	private int getFiguresRow() {
		if (this.color == Color.WHITE) {
			return Player.WHITE_FIGURES_ROW;
		}
		return Player.BLACK_FIGURES_ROW;
	}
	private int getFiguresChessRow() {
		if (this.color == Color.WHITE) {
			return Player.WHITE_FIGURES_CHESSROW;
		}
		return Player.BLACK_FIGURES_CHESSROW;
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
	
	public static void main(String[] args) {
		IO io = new IO();
		Player player = new Player(0);
		
		int chessmenSize = player.chessmen.size();
		io.writeln("chessmenSize: " + chessmenSize);
		
		Chessman chessman = player.chessmen.get(0);
		io.writeln("chessman letter: " + chessman.getLetter(Color.WHITE));
		ChessCoordinate coordinate = chessman.getCoordinate();
		coordinate.show();
	}

}
