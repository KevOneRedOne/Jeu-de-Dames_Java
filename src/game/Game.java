package game;

import java.util.ArrayList;
import menu.Menu;
import models.Pion;
//import utils.Utilitary;
import utils.Utilitary;

public class Game {
	static int sizeTab = 10;
	static char [][] board = new char[sizeTab][sizeTab];
	
	static ArrayList<Pion> PionPlayer1 = new ArrayList<Pion>();
	static ArrayList<Pion> PionPlayer2 = new ArrayList<Pion>();
	
	public void launchGame() {
		Menu.MenuPrincipal(PionPlayer1, PionPlayer2, board);
//		MovePiecePlayer1();
//		Utilitary.printMap(board);
		test();
		
	}
//	
//	public static void MovePiecePlayer1() {
//		System.out.println("Abscisse X de votre pièce (Entre 0 et 9) : ");
//		int readCoordonneeX = Utilitary.readInt(); 
//		System.out.println("Ordonnée Y de votre pièce (Entre 0 et 9) : ");
//		int readCoordonneeY = Utilitary.readInt(); 
//		System.out.println("Verification de l'existance de la pièce aux coordonnées : " + readCoordonneeX + ","+ readCoordonneeY);
//		
//		for (Pion pionAdeplacer : PionPlayer1) {
//			if(pionAdeplacer.getPosX() == readCoordonneeX && pionAdeplacer.getPosY() == readCoordonneeY) {
//				System.out.println(pionAdeplacer);
//				System.out.println("Votre pièce existe.");
//				System.out.println("Où souhaitez-vous déplacer votre pièce ? ");
//				System.out.println("Abscisse X (Entre 0 et 9) : ");
//				int coordonneeX = Utilitary.readInt(); 
//				System.out.println("Ordonnée Y (Entre 0 et 9) : ");
//				int coordonneeY = Utilitary.readInt(); 
//				PionPlayer1.remove(pionAdeplacer);
//				pionAdeplacer.setPosX(coordonneeX);
//				pionAdeplacer.setPosY(coordonneeY);
//				PionPlayer1.add(pionAdeplacer);
//				
//			} 			
//		}
//		
//	}
	
	public static void test() {
		System.out.println("Abscisse X de votre pièce (Entre 0 et 9) : ");
		int readCoordonneeX = Utilitary.readInt(); 
		System.out.println("Ordonnée Y de votre pièce (Entre 0 et 9) : ");
		int readCoordonneeY = Utilitary.readInt(); 
		System.out.println("Verification de l'existance de la pièce aux coordonnées : " + readCoordonneeX + ","+ readCoordonneeY);
		
		for (Pion pionAdeplacer : PionPlayer1) {
			if(pionAdeplacer.getPosX() == readCoordonneeX && pionAdeplacer.getPosY() == readCoordonneeY) {
//				PionPlayer1.remove(pionAdeplacer);
				System.out.println("Abscisse X (Entre 0 et 9) : ");
				int coordonneeX = Utilitary.readInt(); 
				System.out.println("Ordonnée Y (Entre 0 et 9) : ");
				int coordonneeY = Utilitary.readInt(); 
//				PionPlayer1.add(pionAdeplacer);
				pionAdeplacer.setPosX(coordonneeX);
				pionAdeplacer.setPosY(coordonneeY);
				System.out.println(pionAdeplacer);
					
				}
			}
		
			for (Pion pion : PionPlayer1) {
				System.out.println(pion);
				
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
