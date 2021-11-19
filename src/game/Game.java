package game;

import java.util.ArrayList;

import menu.Menu;
import models.Pion;
import utils.Utilitary;

public class Game {
	int sizeTabX = 10;
	int sizeTabY = 10;
	
	char [][] board = new char[sizeTabX][sizeTabY];
	ArrayList<Pion> PionPlayer1 = new ArrayList<Pion>();
	ArrayList<Pion> PionIA = new ArrayList<Pion>();
		
	public void launchGame() {
		Menu.MenuPrincipal();
		
		Utilitary.fillBoard(board);
		createPieceIA(board);
		createPiecePlayer1(board);
		Utilitary.printMap(board);
		
	}
	
	private void createPieceIA(char[][] board) {	
		for (int row = 0; row <= 3 ; row++) {
			for (int col = 0; col < board.length; col++) {
                if (row%2==0) {
                    if (col%2 == 1) {
                        PionIA.add(new Pion('X', col, row, "black"));
                    }
                }
                if (row%2==1) {
                    if (col%2==0) {
                        PionIA.add(new Pion('X', col, row, "black"));
                    }
                }
			}
		}	
		for (Pion listPionIA : PionIA) {
			board[listPionIA.getPosX()][listPionIA.getPosY()] = listPionIA.getTypePiece();
		}
	}
	
	private void createPiecePlayer1(char[][] board) {	
		for (int row = 6 ; row <= 9; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row%2==0) {
					if (col%2 == 1) {
						PionPlayer1.add(new Pion('O', col, row, "white"));
					}
				}
				if (row%2==1) {
					if (col%2==0) {
						PionPlayer1.add(new Pion('O', col, row, "white"));
					}
				}
			}
		}	
		for (Pion listPionJ1 : PionPlayer1) {
			board[listPionJ1.getPosX()][listPionJ1.getPosY()] = listPionJ1.getTypePiece();
		}
	}
}

