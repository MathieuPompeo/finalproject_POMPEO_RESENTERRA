package finalproject_POMPEO_RESENTERRA;

import java.awt.Font;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;


public class Board {

static Square[][] board;
	
	public Board(int size, int obstacle) {
		board = new Square[size][size];
		int nbtest = 0;
		for(int i=0; i< size; i++) { 
			for(int j=0; j<size;j++) {
				nbtest = 1 + (int)(Math.random() * ((6 - 1) + 1));
				switch (nbtest) {
				case 1:
					board[i][j] = new Square(i, j,SquareState.RED);
					break;
				case 2:
					board[i][j] = new Square(i, j,SquareState.ORANGE);
					break;
				case 3:
					board[i][j] = new Square(i, j,SquareState.YELLOW);
					break;
				case 4:
					board[i][j] = new Square(i, j,SquareState.GREEN);
					break;
				case 5:
					board[i][j] = new Square(i, j,SquareState.BLUE);
					break;
				case 6:
					board[i][j] = new Square(i, j,SquareState.PURPLE);
					break;
				default:
					break;
				}
			}
		}
	while(board[size-1][0].getState()==board[0][size-1].getState()){ // Pas fini
			System.out.println("test");
			nbtest = 1 + (int)(Math.random() * ((6 - 1) + 1));
			switch (nbtest) {
			case 1:
				setSquareState(0, size-1,SquareState.RED);
			case 2:
				setSquareState(0, size-1,SquareState.ORANGE);
			case 3:
				setSquareState(0, size-1,SquareState.YELLOW);
			case 4:
				setSquareState(0, size-1,SquareState.GREEN);
			case 5:
				setSquareState(0, size-1,SquareState.BLUE);
			case 6:
				setSquareState(0, size-1,SquareState.PURPLE);
		}
	}
	
	// On gère les obstacles : 
	
	if (obstacle==1){ // Obstacle aléatoire
		for(int i=1; i< size-1; i++) { 
			for(int j=1; j<size-1;j++) {
				nbtest = 1 + (int)(Math.random() * ((6 - 1) + 1));
				switch (nbtest) {
				case 3:
					setSquareState(i, j,SquareState.BLACK);
					break;
				default:
					break;
				}
			}
		
		}
	}
	
	if (obstacle==2){
		int i=(int) Math.floor(size/2);
		for(int j=(int) Math.floor(size/3); j<size-(int) Math.floor(size/3);j++) {
				setSquareState(i, j,SquareState.BLACK);
				setSquareState(j, i,SquareState.BLACK);
				
			}
		
		}
		
	}

	
	
	public void setSquareState(int i, int j,SquareState state) {
		board[i][j].setState(state);
	}
	
	public SquareState getSquareState(int i, int j) {
		return board[i][j].getState();
	}
	
	static boolean checkCoords(int i, int j) { // Pour regarder si on est toujours sur la grille
		
		return i>=0 && j>=0 && i < board.length && j < board.length;
	}

	
	
	int getSize() {

		return board.length;
	}
	
	
	public void applyMove(SquareState move, Player current,ArrayList<Player> listPlayer, int nbPlayer) throws Exception {
		
		if (nbPlayer==2) {
			if(move==listPlayer.get(0).color || move==listPlayer.get(1).color ) {
				
				throw new Exception("You can't choose this color.");	
			}	
		}
		
		if (nbPlayer==3) {
			if(move==listPlayer.get(0).color || move==listPlayer.get(1).color || move==listPlayer.get(2).color ) {
				
				throw new Exception("You can't choose this color.");	
			}	
			
		}

		if (nbPlayer==4) {
			if(move==listPlayer.get(0).color || move==listPlayer.get(1).color || move==listPlayer.get(2).color || move==listPlayer.get(3).color ) {
				
				throw new Exception("You can't choose this color.");	
			}	
	
		}
		
		if (move==SquareState.BLACK) {
				throw new Exception("This is a wall, you can't choose this color.");	
		}
		
		return;	
	} 
	
	
	public void showBoard(ArrayList<Player> listPlayer) {
		StdDraw.setXscale(-1,this.getSize()+4);
		StdDraw.setYscale(-1,this.getSize());
		//System.out.println(this.getSize());
		
		 StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        
        // StdDraw.picture(20, 20, "fond2.jpg",40, 40); // Pour ajouter un image de fond
        
        // Affichage des scores
        
        Font font = new Font("Arial", Font.BOLD, 25);
        Font font2 = new Font("Arial", Font.BOLD, 40);
        StdDraw.setFont(font2);
        StdDraw.text(this.getSize()+2, this.getSize()-1, "Score");
//        StdDraw.text(this.getSize()+1, this.getSize()-2, "Top: "+Integer.toString(Game.getScoreTop()));
//		StdDraw.text(this.getSize()+1, this.getSize()-3, "Bot: "+Integer.toString(Game.getScoreBot()));
		
		
//		for(int i = 0;i<this.getSize(); i++) {
//			StdDraw.line(i+0.5, 0.5, i+0.5, this.getSize()-1+0.5);
//			StdDraw.line(0.5,i+0.5, this.getSize()-1+0.5,i+0.5 );
//		} Pour le lignes noires
        StdDraw.setFont(font);
		int space2=2;
		for (int i=0; i<listPlayer.size(); i++){
			StdDraw.text(this.getSize()+2, this.getSize()-space2, listPlayer.get(i).name+": "+Integer.toString(listPlayer.get(i).score)); 
			space2+=1;
		}
		
		// Affichage de la grille
		
		double rad = 0.5; // Taille des carrés
		for(int i = 0; i < board.length;i++) {
			for(int j = 0; j<board.length; j++) {
				switch (board[i][j].getState()) {
				case RED:
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledSquare(i, j, rad);
					break;
				case ORANGE:
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledSquare(i, j, rad);
					break;
				case YELLOW:
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledSquare(i, j, rad);
					break;
				case GREEN:
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.filledSquare(i, j, rad);
					break;
				case BLUE:
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.filledSquare(i, j, rad);
					break;
				case PURPLE:
					StdDraw.setPenColor(StdDraw.PINK);
					StdDraw.filledSquare(i, j, rad);
					break;
				default:
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(i, j, rad);
					break;

				}
			}
		}
	}

}
