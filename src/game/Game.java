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
	static ArrayList<Pion> PionIA = new ArrayList<Pion>();
	
	public void launchGame() {
		Menu.MenuPrincipal();
		
		Utilitary.fillBoard(board);
		createPieceIA();
		createPiecePlayer1();
		MovePiecePlayer1();
		Utilitary.printMap(board);
		
	}
	
	private void MovePiecePlayer1() {
		
		for (Pion pion : PionPlayer1) {
			System.out.println(pion);
		}
	}
	
	
	
	
	
	public static void createPieceIA() {	
		for (int row = 0; row <= 3 ; row++) {
			for (int col = 0; col < board.length; col++) {
                if (row%2==0) {
                    if (col%2 == 1) {
                        PionIA.add(new Pion('X', col, row, false, "black"));
                    }
                }
                if (row%2==1) {
                    if (col%2==0) {
                        PionIA.add(new Pion('X', col, row, false, "black"));
                    }
                }
			}
		}	
		for (Pion listPionIA : PionIA) {
			board[listPionIA.getPosX()][listPionIA.getPosY()] = listPionIA.getTypePiece();
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
		for (Pion listPionJ2 : PionPlayer2) {
			board[listPionJ2.getPosX()][listPionJ2.getPosY()] = listPionJ2.getTypePiece();
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
		for (Pion listPionJ1 : PionPlayer1) {
			board[listPionJ1.getPosX()][listPionJ1.getPosY()] = listPionJ1.getTypePiece();
		}
	}
}