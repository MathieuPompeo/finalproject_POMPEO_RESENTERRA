package finalproject_POMPEO_RESENTERRA;

import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class HumanPlayer extends Player {
	
	static private Scanner scan;
	
	
	public static synchronized  void setScanner(Scanner scanner) {
		scan = scanner; 
	}
	public HumanPlayer(String name, boolean isHuman, int placePlayer, Board board)
			throws Exception {
		super(name, isHuman, placePlayer, board);
		
	}

	public Square getMove() {
		System.out.println("Player " + super.getName()+ " to play: ");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		return new Square(x,y, super.getColor());
		
		
	}
	public static SquareState detectMoveHuman(Board board, Player current, ArrayList<Player> listPlayer) {
		// unPass();
		
		System.out.println("Player " + current.getName() + " to play: " + current.color);
		
		double x, y;
		boolean over2=false;
		while(!StdDraw.mousePressed() || !over2) {
			StdDraw.clear();
			board.showBoard(listPlayer);
			x = StdDraw.mouseX();
			y = StdDraw.mouseY();
			StdDraw.show(33);
			if (board.checkCoords((int) Math.round(x), (int) Math.round(y))){
				over2=true;
			}
			else {
				over2=false;
			}
		}
		
		
		x = StdDraw.mouseX();
		y = StdDraw.mouseY();
		System.out.println(x + " "+ y);
		int xPos = (int) Math.round(x);
		int yPos = (int) Math.round(y);
		System.out.println(xPos + " "+ yPos);
		while(StdDraw.mousePressed()) {
			StdDraw.show(33);
		}
		return Board.board[xPos][yPos].getState();
		
		
	}
	
	
	

}
