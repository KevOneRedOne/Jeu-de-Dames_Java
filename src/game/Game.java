package game;

import java.util.ArrayList;
import menu.Menu;
import models.Pion;
import utils.Utilitary;

public class Game {
	static int sizeTab = 10;
	 static char [][] board = new char[sizeTab][sizeTab];

	ArrayList<Pion> PionPlayer1 = new ArrayList<Pion>();
	ArrayList<Pion> PionPlayer2 = new ArrayList<Pion>();
	
	public void launchGame() {
		Menu.MenuPrincipal(PionPlayer1, PionPlayer2, board);	
	
	}
	
	
	public static void MovePiecePlayer(ArrayList<Pion> PionPlayer) {
		System.out.println("Abscisse X de votre pièce (Entre 0 et 9) : ");
		int readCoordonneeX = Utilitary.readInt(); 
		System.out.println("Ordonnée Y de votre pièce (Entre 0 et 9) : ");
		int readCoordonneeY = Utilitary.readInt(); 
		System.out.println("Verification de l'existance de la pièce aux coordonnées : " + readCoordonneeX + ","+ readCoordonneeY);
		for (Pion pion : PionPlayer) {
			if (readCoordonneeX == pion.getPosX() && readCoordonneeY == pion.getPosY()) {
				System.out.println("Votre pion existe.");
				System.out.println("Où souhaitez-vous déplacer votre pièce ? ");
				System.out.println("Abscisse X (Entre 0 et 9) : ");
				int NewCoordonneeX = Utilitary.readInt(); 
				System.out.println("Ordonnée Y (Entre 0 et 9) : ");
				int NewCoordonneeY = Utilitary.readInt(); 
				pion.setPosX(NewCoordonneeX);
				pion.setPosY(NewCoordonneeY);
				CheckNextPos(NewCoordonneeX, NewCoordonneeY);
			} else {
				System.out.println("Votre pion n'existe pas.\nRecommencez une dernière fois, avant de passer votre tour ! ");
				System.out.println("Abscisse X de votre pièce (Entre 0 et 9) : ");
				readCoordonneeX = Utilitary.readInt(); 
				System.out.println("Ordonnée Y de votre pièce (Entre 0 et 9) : ");
				readCoordonneeY = Utilitary.readInt(); 
				for (Pion pion2 : PionPlayer) {
					if (readCoordonneeX == pion2.getPosX() && readCoordonneeY == pion2.getPosY()) {
						System.out.println("Où souhaitez-vous déplacer votre pièce ? ");
						System.out.println("Abscisse X (Entre 0 et 9) : ");
						int NewCoordonneeX = Utilitary.readInt(); 
						System.out.println("Ordonnée Y (Entre 0 et 9) : ");
						int NewCoordonneeY = Utilitary.readInt(); 
						pion2.setPosX(NewCoordonneeX);
						pion2.setPosY(NewCoordonneeY);
						CheckNextPos(NewCoordonneeX, NewCoordonneeY);
					}
				}
			}
			break;
		}					
	}
		
//	TODO Fonction pour checker la case suivante avec les coordonnées
	public static void CheckNextPos(int posX, int posY) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (posX == i && posY == j) {
					System.out.print(i);
					System.out.print(j);
				}
				
			}
		}
	}
	
	
	
	
	
	
	public static char[][] FillCheckers(ArrayList<Pion> PionPlayer1, ArrayList<Pion> PionPlayer2) {
		char [][] Newboard = new char[sizeTab][sizeTab];
		
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
	
	public static void createPiecePlayer1(ArrayList<Pion> PionPlayer1) {	
		for (int row = 6 ; row <= 9; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row%2==0) {
					if (col%2 == 1) {
						PionPlayer1.add(new Pion('O', row, col, true, "white"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer1.add(new Pion('O', row, col, true, "white"));
					}
				}
			}
		}	
	}

	public static void createPiecePlayer2(ArrayList<Pion> PionPlayer2) {	
		for (int row = 0; row <= 3 ; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row%2==0) {
					if (col%2 == 1) {
						PionPlayer2.add(new Pion('X', row, col, true, "black"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer2.add(new Pion('X', row, col, true, "black"));
					}
				}
			}
		}	
	}
}