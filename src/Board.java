
public class Board {

	private int[][] chessBoard;
	
	public static final int ROWS_NUMBER = 8;
	public static final int COLUMNS_NUMBER = 8;
	private static final char EMPTY_SQUARE_CHAR = '·';
	private static final char[] ROW_NUMBERS = {8, 7, 6, 5, 4, 3, 2, 1};
	private static final char[] COLUMN_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	
	public Board() {
		
	}

	public void show(Player[] players) {
		assert (players != null);
		IO io = new IO();
		for (int row = 0; row < Board.ROWS_NUMBER; row++) {
			for (int column = 0; column < Board.COLUMNS_NUMBER; column++) {
				boolean hasChessman = false;
				ChessCoordinate target = new ChessCoordinate(row, column);
				for (Player player : players) {
					if (player.hasChessmanIn(target)) {
						io.write(" " + player.getLetterOfChessmanIn(target));
						hasChessman = true;
					}
				}
				if (!hasChessman) {
					io.write(" " + Board.EMPTY_SQUARE_CHAR);
				}
			}
			io.writeln();
		}
	}

}
