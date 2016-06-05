package finalproject_POMPEO_RESENTERRA;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private final Board board;
	private final static ArrayList<Player> listPlayer= new ArrayList<>();
	private int nbPlayer;
	
	
	public Game(int size, int obstacle) {
		this.board = new Board(size, obstacle);	
	}
	
	public List<Player> getListPlayer() {
		return listPlayer;
	}


	public static void addNewPlayer(Player player){
		listPlayer.add(player);
	}



	public void changePlay(int i, int j,SquareState move, Player current) {
		if (Board.checkCoords(i,j)){
			if (Board.board[i][j].getPlayer()==current && Board.board[i][j].getState()!=move){
				Board.board[i][j].setState(move);
				
				changePlay(i+1, j, move, current);
				changePlay(i, j+1, move, current);
				changePlay(i-1, j, move, current);
				changePlay(i, j-1, move, current);
			}
			else if (Board.board[i][j].getState()==move && Board.board[i][j].getPlayer()!=current ){
				Board.board[i][j].setPlayer(current);
				
				changePlay(i+1, j, move, current);
				changePlay(i, j+1, move, current);
				changePlay(i-1, j, move, current);
				changePlay(i, j-1, move, current);
			}
			else if ((i==0 && j==board.getSize()-1) || (i==board.getSize()-1 && j==0) ){
				changePlay(i+1, j, move, current);
				changePlay(i, j+1, move, current);
				changePlay(i-1, j, move, current);
				changePlay(i, j-1, move, current);
			}
			
		}
	}
	public void play() {
		boolean over =false;
		int currentPlayer=0;
		Player current = listPlayer.get(currentPlayer), next = listPlayer.get(currentPlayer+1);
		
		SquareState color0=Board.board[board.getSize()-1][0].getState(); //Va chercher la couleur de départ de J1 
		current.changeColor(color0); // Change la couleur de départ de J1
		changePlay(board.getSize()-1, 0, color0, current);
		Board.board[board.getSize()-1][0].setPlayer(current); // Assigne joueur aux cases bot et top
		
		SquareState color1=Board.board[0][board.getSize()-1].getState();
		next.changeColor(color1);
		changePlay(0, board.getSize()-1, color1, next);
		Board.board[0][board.getSize()-1].setPlayer(next);
		
		if (nbPlayer>2){
			SquareState color2=Board.board[board.getSize()-1][board.getSize()-1].getState();
			listPlayer.get(2).changeColor(color2);
			changePlay(board.getSize()-1, board.getSize()-1, color2, listPlayer.get(2));
			Board.board[board.getSize()-1][board.getSize()-1].setPlayer(listPlayer.get(2));
		}
		
		
		if (nbPlayer>3){
			SquareState color3=Board.board[0][0].getState();
			listPlayer.get(3).changeColor(color3);
			changePlay(0,0, color3, listPlayer.get(3));
			Board.board[0][0].setPlayer(listPlayer.get(3));
		}
		
		
		// On donne les cases adjacente de la même couleur à chaque joueur pour commencer.
		board.showBoard(listPlayer);
		while(!over) {
			
			SquareState move = null;
			boolean illegal = true;
			int nbSquareTaken=2;
			int red;
			int blue;
			int yellow;
			int green;
			int purple;
			int orange; 
			int totalColor;
			
			while(illegal) {
				// On recalcule les scores
				
				for(int j=0; j< listPlayer.size(); j++){
					listPlayer.get(j).score=0;
				}
				
				for(int i=0; i< board.getSize(); i++) { 
					for(int j=0; j<board.getSize();j++) {
						if (Board.board[i][j].getPlayer()!=null){
							Board.board[i][j].getPlayer().score+=1;
						}
					}
				}
				
				nbSquareTaken=0; // On calule ici si toute les cases sont prises
				for(int i=0; i< board.getSize(); i++) { 
					for(int j=0; j<board.getSize();j++) {
						if (Board.board[i][j].getPlayer()!=null){
							nbSquareTaken+=1;
							
						}
					}
				}
				
				red=0;
				blue=0;
				yellow=0;
				green=0;
				purple=0;
				orange=0;
				
				for(int i=0; i< board.getSize(); i++) { 
					for(int j=0; j<board.getSize();j++) {
						if (Board.board[i][j].getState()==SquareState.RED){
							red=1;
						}
						if (Board.board[i][j].getState()==SquareState.ORANGE){
							orange=1;
						}
						if (Board.board[i][j].getState()==SquareState.BLUE){
							blue=1;
						}
						if (Board.board[i][j].getState()==SquareState.YELLOW){
							yellow=1;
						}
						if (Board.board[i][j].getState()==SquareState.PURPLE){
							purple=1;
						}
						if (Board.board[i][j].getState()==SquareState.GREEN){
							green=1;
						}
						
					}
				}
				
				totalColor=red+blue+yellow+green+purple+orange;
				
				
				if ((current.score > (board.getSize()*board.getSize())/2) 
						|| nbSquareTaken == (board.getSize()*board.getSize()) 
						|| totalColor<=nbPlayer){
					over=true;
				} // POUR FINIR LE JEU 
				
				move = current.detectMove(board, current, listPlayer); // Ici qu'on change entre joueur et AI
				System.out.println(move);
			
				try {
					board.applyMove(move, current, listPlayer, nbPlayer); 
					illegal =false;
					
				} catch(Exception e) {
					System.out.println("Exception " + e.getMessage());
					illegal = true;	
				}
			}
			
			/// Les actions à faire 
			
			current.changeColor(move);
			if (currentPlayer==0){
				changePlay(board.getSize()-1, 0, move, current);
			}
			
			else if (currentPlayer==1){
				changePlay(0, board.getSize()-1, move, current);
			}
			
			else if (currentPlayer==2){
				changePlay(board.getSize()-1, board.getSize()-1, move, current);
			}
			
			else if (currentPlayer==3){
				changePlay(0, 0, move, current);
			}
			
			
			// On change de joueur
			if (currentPlayer==nbPlayer-1){
				currentPlayer=0;
				current = listPlayer.get(currentPlayer);
				next = listPlayer.get(currentPlayer+1);
			}
			else if (currentPlayer==nbPlayer-2) {
				currentPlayer+=1;
				current = listPlayer.get(currentPlayer);
				next = listPlayer.get(0);
			}
			else {
				currentPlayer+=1;
				current = listPlayer.get(currentPlayer);
				next = listPlayer.get(currentPlayer+1);
			}
			
			
		}
		computeAndShowScore(nbPlayer);
		System.out.println("Made by Mathieu POMPEO and Marc RESENTERA");
		
	}
	
	private void computeAndShowScore(int nbPlayer) { // Affiche les scores
		boolean over=false;
			StdDraw.clear();
			StdDraw.setCanvasSize(800,800);
			Font font = new Font("Arial", Font.BOLD, 40);
			Font font2 = new Font("Arial", Font.BOLD, 70);
			StdDraw.setPenRadius(0.03);
			StdDraw.setXscale(0, 40);
			StdDraw.setYscale(0, 40); 
			StdDraw.setPenColor(StdDraw.BLACK); 
			StdDraw.picture(20, 20, "fond.jpg",40, 40); // Pour ajouter un image de fond
			
			StdDraw.setFont(font2);
			StdDraw.text(20, 35, "Score");
			StdDraw.setFont(font);
			int space=0;
			for (int i=0; i<nbPlayer; i++){
				StdDraw.text(13, 30-space, listPlayer.get(i).name+": "+Integer.toString(listPlayer.get(i).score)); 
				space+=3;
			}
			StdDraw.show(33);
	
	}

	public static void main(String[] args) {
		
		Menu.showMenu();
		int size = (int) Menu.listMenu.get(0);
		int nbPlayer2 = (int) Menu.listMenu.get(1);
		int obstacle = (int) Menu.listMenu.get(2);
		Object[][] players = (Object[][]) Menu.listMenu.get(3);
		
		
		
		try {
			Scanner scanner  = new Scanner(System.in);
			HumanPlayer.setScanner(scanner);
			int taille;
			if (size>13){
				taille = 13*70;
			}
			else {
				taille = size*70;
			}
			StdDraw.setCanvasSize(taille+200,taille);
			Game g = new Game(size, obstacle);
			g.nbPlayer = nbPlayer2;
			Player joueur;
			for (int i=0; i<g.nbPlayer ; i++){
				joueur = new HumanPlayer((String)players[i][0], (boolean)players[i][1], i, g.board);
				addNewPlayer(joueur);
			}
			g.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			

	}

}
