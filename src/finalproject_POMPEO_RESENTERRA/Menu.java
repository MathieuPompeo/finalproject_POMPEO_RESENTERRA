package finalproject_POMPEO_RESENTERRA;

import java.awt.Font;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class Menu {
	
	static ArrayList<Object> listMenu= new ArrayList<>();
	
	
	public static ArrayList<Object> getListMenu() {
		return listMenu;
	}



	public static void setListMenu(ArrayList<Object> listMenu) {
		Menu.listMenu = listMenu;
	}


	
	public static void showMenu() {
		boolean over = false;
		int size = 13;
		int nbPlayer2 = 2;
		int obstacle=0;
		
		StdDraw.setCanvasSize(800,800);
		Font font = new Font("Arial", Font.BOLD, 26);
		Font font2 = new Font("Arial", Font.BOLD, 21);
		Font fontTitle = new Font("Arial", Font.BOLD, 50);
		
		// Initialisation du tableau du choix des caracteristiques des joueurs
		Object[][] players = new Object[4][2];
		players[0][0]="Joueur 1";
		players[0][1]=true;
		players[1][0]="Joueur 2";
		players[1][1]=false;
		players[2][0]="Joueur 3";
		players[2][1]=true;
		players[3][0]="Joueur 4";
		players[3][1]=true;
		
		// Conditions initiales
		StdDraw.setFont(font2);
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLACK); 
		StdDraw.square(24, 30, 0.5); 
		
		/// Initialisation des dessins en fonction des variables initiales
		StdDraw.setPenColor(StdDraw.BLACK); 
		StdDraw.square(18, 12, 0.5); 
		StdDraw.square(24, 30, 0.5); 
		
		///
		
		while(!over){
			double rad=0.5;
			StdDraw.setPenRadius(0.015);
			StdDraw.setXscale(0, 40);
			StdDraw.setYscale(0, 40); 
			StdDraw.setPenColor(StdDraw.BLACK); 
			
			StdDraw.picture(20, 20, "fond.jpg",40, 40); // Pour ajouter un image de fond
			
			StdDraw.setFont(fontTitle);
			StdDraw.text(20, 37, "6 Couleurs");
			
			StdDraw.setFont(font);
			StdDraw.text(8, 33, "Taille de la grille : ");
			
			StdDraw.text(8, 27, "Choix des joueurs : ");
			
			StdDraw.text(10, 24, "Nbre de joueurs : ");
			
			StdDraw.text(20.5, 23.8, Integer.toString(nbPlayer2));
			
			StdDraw.line(18, 24, 19, 24);
			
			StdDraw.line(22, 24, 23, 24);
			StdDraw.line(22.5, 23.5, 22.5, 24.5);
			
			StdDraw.text(8, 12, "Niveau de grille : ");
			
			StdDraw.text(8, 8, "Règles avancées : ");
			
			StdDraw.setFont(font2);
			
			int space2=0;
			for (int i=0; i<nbPlayer2; i++){
				if((boolean)players[i][1]==true){
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(18, 22-(space2), rad); 
				}
				else {
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(27, 22-(space2), rad); 
				}
				space2+=2;
			}
			
			if (size==5){
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(8, 30, rad); 
			}
			
			if (size==9){
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(16, 30, rad); 
			}
			if (size==13){
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(24, 30, rad); 
			}
			if (size==21){
	
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(32, 30, rad); 
			}
			
			if (obstacle==0){
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(18, 11, rad); 
			}
			
			if (obstacle==2){
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(26, 11, rad); 
			}

			if (obstacle==1){
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(34, 11, rad); 
			}
			
			
			
			
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledSquare(20, 3, 1.8); 
			StdDraw.setPenColor(StdDraw.WHITE); 
			StdDraw.text(20, 3,"Go"); 
			StdDraw.setPenColor(StdDraw.GREEN); 
			StdDraw.filledSquare(8, 30, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(8, 31, "5x5");
			StdDraw.setPenColor(StdDraw.YELLOW); 
			StdDraw.filledSquare(16, 30, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(16, 31, "9x9");
			StdDraw.setPenColor(StdDraw.ORANGE); 
			StdDraw.filledSquare(24, 30, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(24, 31, "13x13");
			StdDraw.setPenColor(StdDraw.RED); 
			StdDraw.filledSquare(32, 30, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(32, 31, "21x21");
			
			// Bouton Obstacles
			
			StdDraw.setPenColor(StdDraw.YELLOW); 
			StdDraw.filledSquare(18, 11, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(18, 13, "Sans");
			StdDraw.text(18, 12, "obstacles");
			StdDraw.setPenColor(StdDraw.ORANGE); 
			StdDraw.filledSquare(26, 11, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(26, 13, "Avec obstacles");
			StdDraw.text(26, 12, "prédéfinis");
			StdDraw.setPenColor(StdDraw.RED); 
			StdDraw.filledSquare(34, 11, rad); 
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(34, 13, "Avec obstacles");
			StdDraw.text(34, 12, "aléatoires");
			
			// Choix des joueurs
			
			int space=0;
			for (int i=0; i<nbPlayer2; i++){
				StdDraw.setFont(font);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(10, 22-(space), (String) players[i][0]); // Texte
				
				// Bouton
				StdDraw.setFont(font2);
				StdDraw.setPenColor(StdDraw.GREEN); 
				StdDraw.filledSquare(18, 22-(space), rad); 
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(21, 22-(space), "Humain");
				StdDraw.setPenColor(StdDraw.BLUE); 
				StdDraw.filledSquare(27, 22-(space), rad); 
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(31, 22-(space), "Ordinateur");
				
				space+=2;
				
			}
			
			
			StdDraw.show(33);
			
			double x, y;
			while(!StdDraw.mousePressed()) {
				x = StdDraw.mouseX();
				y = StdDraw.mouseY();
				StdDraw.show(33);
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
			
			if (xPos<20+2 && xPos>20-2 && yPos<3+2 && yPos>3-2 && size>4){ // Bouton GO
				over=true;
			}
			
			// On réinitialise les bordures des carrées des tailles
			StdDraw.setPenColor(StdDraw.WHITE); 
			StdDraw.square(8, 30, rad+0.1); 
			StdDraw.square(16, 30, rad+0.1); 
			StdDraw.square(24, 30, rad+0.1); 
			StdDraw.square(32, 30, rad+0.1); 
			
			// On réinitialise les bordures des carrées des obstacles
			StdDraw.setPenColor(StdDraw.WHITE); 
			StdDraw.square(8, 12, rad+0.1); 
			StdDraw.square(18, 11, rad+0.1); 
			StdDraw.square(26, 11, rad+0.1); 
			StdDraw.square(34, 11, rad+0.1); 
			
			if (yPos==30 && xPos==8){ // Choix de taille 5x5
				size=5;
			}
			
			else if (yPos==30 && xPos==16){ // Choix de taille 9x9
				size=9;
			}
			
			else if (yPos==30 && xPos==24){ // Choix de taille 13x13
				size=13;
			}
			
			else if (yPos==30 && xPos==32){ // Choix de taille 21x21
				size=21;
			}
			
			
			else if (yPos>=10 && yPos<=14 && xPos>=15 && xPos<=21){ // Choix des obstacles
				obstacle=0;
			}
			
			else if (yPos>=10 && yPos<=14 && xPos>=22 && xPos<=29){ // Choix des obstacles
				obstacle=2;
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(26, 11, rad); 
			}
			

			else if (yPos>=10 && yPos<=14 && xPos>=31 && xPos<=37){ // Choix des obstacles
				obstacle=1;
				
				// On met le contour noir sur la case sélectionnée
				StdDraw.setPenColor(StdDraw.BLACK); 
				StdDraw.square(34, 11, rad); 
			}
			
			if (xPos<=23 && xPos>=22 && yPos<=25 && yPos>=23){ // Bouton +
				StdDraw.setPenColor(StdDraw.WHITE); 
				StdDraw.filledSquare(20, 24, 1); 
				if (nbPlayer2<=3) {
					nbPlayer2+=1;
				}
				else {
					nbPlayer2=2;
				}
			}
			
			if (xPos<=19 && xPos>=18 && yPos<=25 && yPos>=23){ // Bouton -
				StdDraw.setPenColor(StdDraw.WHITE); 
				StdDraw.filledSquare(20, 24, 1); 
				if (nbPlayer2==2) {
					nbPlayer2=4;
				}
				else {
					nbPlayer2-=1;
				}
			}
			
			StdDraw.setPenColor(StdDraw.WHITE); 
			StdDraw.filledRectangle(9, 19, 100, 3.8);
			
			int space3=0;
			for (int i=0; i<nbPlayer2; i++){
				if((xPos==18) && (yPos==22-space3)){
					players[i][1]=true;
				}
				else if((xPos==27) && (yPos==22-space3)){
					players[i][1]=false;
				}
				
				
				if((boolean)players[i][1]==true){
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.square(27, 22-(space3), rad); 
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(18, 22-(space3), rad); 
				}
				else {
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(27, 22-(space3), rad); 
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.square(18, 22-(space3), rad); 
				}
				space3+=2;
				
			}
			
			
			
		}
		Menu.listMenu.add(size);
		Menu.listMenu.add(nbPlayer2);
		Menu.listMenu.add(obstacle);
		Menu.listMenu.add(players);
	}

}
