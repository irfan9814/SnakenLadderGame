package SnakeladderGame;

import java.util.ArrayList;

public class Game {
	Board board;
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Integer> playerPositions = new ArrayList<>();
	Dice d;
	Player winner = null;
	
	public Game(Board board) {
		this.board = board;
		winner = null;
	}
	
	public void addPlayer(Player p) {
		this.players.add(p);
		this.playerPositions.add(0);
	}
	public int move(Player p,int playerIndex, int increment) {
		int currentPosition = playerPositions.get(playerIndex);  //currentPosition = 0  increment =3
		System.out.println(p.name + ": " + currentPosition + " " + increment);
		if((currentPosition + increment) <=100) {			//currentPosition = 0  increment =3
			currentPosition = currentPosition + increment;  //currentPosition = 0 + 3 = 3
		}
		if(this.board.isCurrentPositionSnakeorLadder(currentPosition)!= -1) {
			currentPosition = this.board.isCurrentPositionSnakeorLadder(currentPosition);  //3 ladder: 25
		}
			playerPositions.set(playerIndex, currentPosition);
			
			return currentPosition;
	}
	
	public void start() {
		while(this.winner == null) {
			for(int i=0; i< this.players.size(); i++) {
				Player p = this.players.get(i);
				int position = this.move(p, i, Dice.throwDice());
				if(position >=100) {
					this.winner = p;
					break;
				}
			}
		}
		System.out.println(this.winner.name);
	}
}


