package finalproject_POMPEO_RESENTERRA;

import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;


public abstract class  Player {
	
	String name = "";
	public SquareState color;
	private boolean isHuman;
	public int xStart;
	public int yStart;
	public int score;
	int AI_red=0;
	int AI_orange=0;
	int AI_yellow=0;
	int AI_green=0;
	int AI_blue=0;
	int AI_purple=0;
	SquareState choice;
	
	
	
	public Player(String name, boolean isHuman, int placePlayer, Board board) {
		this.name = name;
		this.isHuman = isHuman;
		if (placePlayer ==0){
			this.xStart=Board.board.length-1;
			this.yStart=0;
		}
		
		if (placePlayer ==1){
			this.xStart=0;
			this.yStart=Board.board.length-1;
		}
		
		if (placePlayer ==2){
			this.xStart=Board.board.length-1;
			this.yStart=Board.board.length-1;
		}
		
		if (placePlayer ==3){
			this.xStart=0;
			this.yStart=0;
		}
		
		
		
	}
	

	
	public abstract Square getMove(); 

	public SquareState getColor() {
		return this.color;
	}
	
	public boolean getCondition() { // Retourne la condition du joueur : humain ou AI
		return this.isHuman;
	}
	
	public void changeCondition(boolean state2) {
		this.isHuman = state2;
	} // Change la condition du joueur
	
	public void changeColor(SquareState state2) {
		this.color = state2;
	} // Change la couleur du joueur
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}


	public SquareState detectMove(Board board, Player current, ArrayList<Player> listPlayer) {
		if (current.isHuman){
			
			return HumanPlayer.detectMoveHuman(board, current, listPlayer);
		}
		
		else {
			
			return AI.detectMoveAI(board,current, listPlayer);	
		}	
	}
	
}
