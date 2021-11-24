package game;

import java.util.ArrayList;
import menu.Menu;
import models.Pion;
//import utils.Utilitary;
import utils.Utilitary;

public class Game {
	static int sizeTabX = 10;
	static int sizeTabY = 10;
	static char [][] board = new char[sizeTabX][sizeTabY];
	
	static ArrayList<Pion> PionPlayer1 = new ArrayList<Pion>();
	static ArrayList<Pion> PionPlayer2 = new ArrayList<Pion>();
	
	public void launchGame() {
		Menu.MenuPrincipal(PionPlayer1, PionPlayer2, board);
//		MovePiecePlayer1();
//		Utilitary.printMap(board);
		
	}
	
	public static void MovePiecePlayer1() {
		System.out.println("Abscisse X de votre pi�ce (Entre 0 et 9) : ");
		int readCoordonneeX = Utilitary.readInt(); 
		System.out.println("Ordonn�e Y de votre pi�ce (Entre 0 et 9) : ");
		int readCoordonneeY = Utilitary.readInt(); 
		System.out.println("Vous avez choisi la pi�ce aux coordonn�es : " + readCoordonneeX + ","+ readCoordonneeY);
		for (Pion pionJ1aDeplacer : PionPlayer1) {
			System.out.println(pionJ1aDeplacer);
		}
	}
	
	public static char[][] FillCheckers(ArrayList<Pion> PionPlayer1, ArrayList<Pion> PionPlayer2, char[][] Newboard) {
		for (int i = 0; i < Newboard.length; i++) {
			for (int j = 0; i <Newboard.length; i++) {
				Newboard[i][j] = ' ' ;	
			}
		}
		for(Pion J1Pion : PionPlayer1) {
			Newboard[J1Pion.getPosX()][J1Pion.getPosY()] = J1Pion.getTypePiece();			
		}
		for(Pion J2Pion : PionPlayer2) {
			Newboard[J2Pion.getPosX()][J2Pion.getPosY()] = J2Pion.getTypePiece();			
		}
		return Newboard; 
	}
	
	public static void createPiecePlayer1() {	
		for (int row = 6 ; row <= 9; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row%2==0) {
					if (col%2 == 1) {
						PionPlayer1.add(new Pion('O', col, row, true, "white"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer1.add(new Pion('O', col, row, true, "white"));
					}
				}
			}
		}	
	}

	public static void createPiecePlayer2() {	
		for (int row = 0; row <= 3 ; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row%2==0) {
					if (col%2 == 1) {
						PionPlayer2.add(new Pion('X', col, row, true, "black"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer2.add(new Pion('X', col, row, true, "black"));
					}
				}
			}
		}	
	}
	
}
