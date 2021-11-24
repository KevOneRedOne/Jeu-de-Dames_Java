package game;

import java.util.ArrayList;

import menu.Menu;
import models.Pion;
import utils.Utilitary;

public class Game {
	static int sizeTabX = 10;
	static int sizeTabY = 10;
	static char [][] board = new char[sizeTabX][sizeTabY];
	
	static ArrayList<Pion> PionPlayer1 = new ArrayList<Pion>();
	static ArrayList<Pion> PionPlayer2 = new ArrayList<Pion>();
	
	public void launchGame() {
//		Menu.MenuPrincipal();
		createPiecePlayer1();
		createPiecePlayer2();
//		appeler FillNewTab à chaque tou
		FillNewTab(PionPlayer1, PionPlayer2, board);

//		MovePiecePlayer1();
		;
		Utilitary.printMap(board);
		
	}
	
//	private void MovePiecePlayer1() {
//		
//		for (Pion pion : PionPlayer1) {
//			System.out.println(pion);
//		}
//	}
	
	public char[][] FillNewTab(ArrayList<Pion> PionPlayer1, ArrayList<Pion> PionPlayer2, char[][] Newboard) {
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
}