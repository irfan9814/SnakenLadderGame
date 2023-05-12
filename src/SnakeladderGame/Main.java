package SnakeladderGame;

public class Main {
	public static void main(String[] args) {
		Game g = new Game(new Board(100));
		g.addPlayer(new Player("Arjun"));
		g.addPlayer(new Player("bheem"));
		
		g.start();
	}
}
