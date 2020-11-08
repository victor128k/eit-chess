public class Chess {

    private Game game;
    
    public Chess() {
    	this.game = new Game();
    }
    
    private void play() {
		do {
			this.game.play();
		} while(this.game.isResumed());
	}
	
	public static void main(String[] args) {
		new Chess().play();
	}
    
    
}
