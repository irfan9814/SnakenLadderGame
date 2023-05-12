package SnakeladderGame;

import SnakenLadderException.SnakeException;
import SnakenLadderException.LadderException;

import java.util.HashMap;

public class Board {
	int cells;

	private HashMap<Integer, Ladder> ladders = new HashMap<Integer, Ladder>();  //we can store ladders
	private HashMap<Integer, Snake> snakes = new HashMap<Integer, Snake>();    //Snakes
	
	public Board(int size) {
		this.cells = size;
		try {
			this.addSnakes(40, 20); //define the value
			this.addSnakes(99, 2);
			
			this.addLadder(10, 90);
			this.addLadder(5, 50);
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
		}
		
	}
	public void addSnakes(int head, int tail) throws SnakeException {
		if(tail>head) {
			throw new SnakeException("For Snake the head value should be higher.");
		}
		this.snakes.put(head, new Snake(head, tail)); //add snake
	}
	public void addLadder(int start, int end) throws LadderException {
		if(start>end) {
			throw new LadderException("For Ladder the end value should be higher.");
		}
		this.ladders.put(start, new Ladder(start, end));
	}
	
	public int isCurrentPositionSnakeorLadder(int position) {
		if(this.snakes.get(position)!= null) {
			System.out.println("Snake Found");
			return this.snakes.get(position).getTail();  // snake head:position tail:?
		}
		if(this.ladders.get(position)!=null) {
			System.out.println("Ladder Found");
			return this.ladders.get(position).getEnd();
		}
		return -1;
	}
	}
