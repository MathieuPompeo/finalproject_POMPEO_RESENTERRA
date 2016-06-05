package finalproject_POMPEO_RESENTERRA;

import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class AI extends Player{

	public AI(String name, boolean isHuman, int placePlayer, Board board) throws Exception {
		super(name, isHuman, placePlayer, board);
	}

	
public static void checkBordure(int i, int j, Player current, SquareState previous) {
		
		if (Board.checkCoords(i,j) && Board.board[i][j].getCheck()!=1){
			
			if(Board.board[i][j].getState()==previous){
				Board.board[i][j].setCheck(1);
				
				if (Board.board[i][j].getState()==SquareState.RED){
					current.AI_red+=1;
				}
				if (Board.board[i][j].getState()==SquareState.ORANGE){
					current.AI_orange+=1;
				}
				if (Board.board[i][j].getState()==SquareState.YELLOW){
					current.AI_yellow+=1;
				}
				if (Board.board[i][j].getState()==SquareState.GREEN){
					current.AI_green+=1;
				}
				if (Board.board[i][j].getState()==SquareState.BLUE){
					current.AI_blue+=1;
				}
				if (Board.board[i][j].getState()==SquareState.PURPLE){
					current.AI_purple+=1;
				}
				
				checkBordure(i+1, j, current, previous);
				checkBordure(i, j+1, current, previous);
				checkBordure(i-1, j, current, previous);
				checkBordure(i, j-1, current, previous);
				
			}
			
		}
	}

	public static void PlayAI(int i, int j, Player current, SquareState previous) {
		
		if (Board.checkCoords(i,j) && Board.board[i][j].getCheck()!=1 && (Board.board[i][j].getPlayer()==null || Board.board[i][j].getPlayer()==current)){
			if (Board.board[i][j].getPlayer()==current){
				
				Board.board[i][j].setCheck(1); // Empeche de repasser au même endroit
				
				PlayAI(i+1, j, current, Board.board[i][j].getState());
				PlayAI(i, j+1, current, Board.board[i][j].getState());
				PlayAI(i-1, j, current, Board.board[i][j].getState());
				PlayAI(i, j-1, current, Board.board[i][j].getState());
			}
			
			else{
				Board.board[i][j].setCheck(1);
				
				if (Board.board[i][j].getState()==SquareState.RED){
					current.AI_red+=1;
				}
				if (Board.board[i][j].getState()==SquareState.ORANGE){
					current.AI_orange+=1;
				}
				if (Board.board[i][j].getState()==SquareState.YELLOW){
					current.AI_yellow+=1;
				}
				if (Board.board[i][j].getState()==SquareState.GREEN){
					current.AI_green+=1;
				}
				if (Board.board[i][j].getState()==SquareState.BLUE){
					current.AI_blue+=1;
				}
				if (Board.board[i][j].getState()==SquareState.PURPLE){
					current.AI_purple+=1;
				}
				
				checkBordure(i+1, j, current, Board.board[i][j].getState());
				checkBordure(i, j+1, current, Board.board[i][j].getState());
				checkBordure(i-1, j, current, Board.board[i][j].getState());
				checkBordure(i, j-1, current, Board.board[i][j].getState());
				
			}
			
		}
	}
	
	public static SquareState detectMoveAI(Board board, Player current, ArrayList<Player> listPlayer) {
		
		System.out.println("Player " + current.getName() + " to play: " + current.color);
		
		
		PlayAI(current.xStart, current.yStart,current, current.color); // Pas les bonnes coordonnées
		
		for(int i=0; i< board.getSize(); i++) {  // Remet les checks des cases à 0
			for(int j=0; j<board.getSize();j++) {
				Board.board[i][j].setCheck(0);
			}
		}
		
		System.out.println(current.AI_red);
		System.out.println(current.AI_orange);
		System.out.println(current.AI_yellow);
		System.out.println(current.AI_green);
		System.out.println(current.AI_blue);
		System.out.println(current.AI_purple);
		
		for (int i=0; i<listPlayer.size(); i++){    /// On empèche le joueur de chosiri la couleur d'un adversaire
			switch (listPlayer.get(i).getColor()) {
			case RED:
				current.AI_red=-1;
				break;
			case ORANGE:
				current.AI_orange=-1;
				break;
			case YELLOW:
				current.AI_yellow=-1;
				break;
			case GREEN:
				current.AI_green=-1;
				break;
			case BLUE:
				current.AI_blue=-1;
				break;
			case PURPLE:
				current.AI_purple=-1;
				break;
			default:
				break;
				
			}
			
		}
		
		
		
		current.choice=SquareState.RED;
		int pivot=current.AI_red;

		if (current.AI_orange>pivot){
			pivot=current.AI_orange;
			current.choice=SquareState.ORANGE;
		}
		if (current.AI_yellow>pivot){
			pivot=current.AI_yellow;
			current.choice=SquareState.YELLOW;
		}
		if (current.AI_green>pivot){
			pivot=current.AI_green;
			current.choice=SquareState.GREEN;
		}
		if (current.AI_blue>pivot){
			pivot=current.AI_blue;
			current.choice=SquareState.BLUE;
		}
		if (current.AI_purple>pivot){
			pivot=current.AI_purple;
			current.choice=SquareState.PURPLE;
		}
		
		
		current.AI_red=0;
		current.AI_orange=0;
		current.AI_yellow=0;
		current.AI_green=0;
		current.AI_blue=0;
		current.AI_purple=0;
		
		return current.choice;
		
	}


	@Override
	public Square getMove() {
		// TODO Auto-generated method stub
		return null;
	}
		

}



