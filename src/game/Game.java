package game;

import java.util.ArrayList;
import models.Pion;
import utils.Utilitary;

public class Game {
	int sizeTabX = 10;
	int sizeTabY = 10;
	boolean isGameOn = true;
	
	char [][] board = new char[sizeTabX][sizeTabY];
	ArrayList<Pion> PionPlayer1 = new ArrayList<Pion>();
	ArrayList<Pion> PionIA = new ArrayList<Pion>();
		
	public void launchGame() {
		
		Utilitary.fillBoard(board);
		createPieceIA(board);
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

}

