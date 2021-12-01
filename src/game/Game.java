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
	
	public static void MovePiecePlayer(ArrayList<Pion> PionPlayer, ArrayList<Pion> PionPlayerNext) {
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
				EatPiece(readCoordonneeX, readCoordonneeY, PionPlayer, PionPlayerNext);
//				TODO Function CheckNextPos, in progress..
				if (CheckNextPos(NewCoordonneeX, NewCoordonneeY, PionPlayer, PionPlayerNext) == true) {
					pion.setPosX(NewCoordonneeX);
					pion.setPosY(NewCoordonneeY);

				} else {						
					System.out.println("Déplacement impossible sur ces coordonnées.\nRecommencez !");	
				}
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
						EatPiece(readCoordonneeX, readCoordonneeY, PionPlayer, PionPlayerNext);
//						TODO Function CheckNextPos, in progress..
						if (CheckNextPos(NewCoordonneeX, NewCoordonneeY, PionPlayer, PionPlayerNext)== true) {
							pion2.setPosX(NewCoordonneeX);
							pion2.setPosY(NewCoordonneeY);
						} else {								
							System.out.println("Déplacement impossible sur ces coordonnées.\nRecommencez !");
						}
					}				
				}	
			}	
			break;
		}					
	}
	
	
//	TODO Function in progress
	public static void MovePieceIA(ArrayList<Pion> PionIA) {
		for (Pion pion : PionIA) {
			System.out.println(pion);
		}
	}
	
	
//	TODO Function in progress	
	public static boolean CheckNextPos(int posX, int posY, ArrayList<Pion> PionPlayer1 , ArrayList<Pion> PionPlayer2) {
		boolean ItsOktoMove = false;
		for (Pion pion : PionPlayer2) {
			for (Pion pion2 : PionPlayer1) {
				if (posX != pion.getPosX() && posY != pion.getPosY() || posX != pion2.getPosX() && posY != pion2.getPosY()) {
					ItsOktoMove = true;				
				} else {
					ItsOktoMove = false;										
				}
			}
		}
		return ItsOktoMove;
	}
	
// TODO Function EatPiece is in progress..
	public static void EatPiece(int posX, int posY, ArrayList<Pion> PionPlayer, ArrayList<Pion> PionPlayerNext) {
//		for (Pion pion : PionPlayerNext) {
//				if(posX != pion.getPosX() && posY != pion.getPosY()) {
//					if (posX-1 == pion.getPosX() && posY+1 == pion.getPosY() || posX-1 == pion.getPosX() && -1 == pion.getPosY()) {
//						PionPlayerNext.remove(pion);
//					}
//				}
//			}
//		System.out.println(PionPlayerNext);
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
						PionPlayer1.add(new Pion('O', row, col, "white"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer1.add(new Pion('O', row, col, "white"));
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
						PionPlayer2.add(new Pion('X', row, col, "black"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer2.add(new Pion('X', row, col, "black"));
					}
				}
			}
		}	
	}
}