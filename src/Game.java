
public class Game {

	private Board board;
	private Player[] players;

	private static final int NUM_PLAYERS = 2;

	public Game () {
		this.board = new Board();
		this.players = new Player[Game.NUM_PLAYERS];
		for(int i = 0; i < Game.NUM_PLAYERS; i++) {
			this.players[i] = new Player(i);
		}
	}

	public void play() {
		this.board.show(players);
	}

	public boolean isResumed() {
		// TODO Auto-generated method stub
		return false;
	}

}
