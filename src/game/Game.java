package game;

public class Game {
	//Attributs	
	int sizeTabX = 10;
	int sizeTabY = 10;
	
	char [][] board = new char[sizeTabX][sizeTabY];
	
	boolean isGameOn = true;
	
	
	//Constructor
	public Game() {
		
	}
	
	
	
	public void game() {
		// TODO Auto-generated method stub
		fillBoard(board);
		
		printBoard(board);
	}
	
	public static void printBoard(char[][] board) {
		System.out.println();
		for (int i = 0; i <= board.length-1; i++){
            for(int j = 0; j <= board.length-1; j++){
                
            	System.out.print(" | " + board[j][i]);    
            }
            System.out.println(" | ");
        }
        System.out.println();
	}
	
	public static void fillBoard(char[][] board) {
		for(int i=0; i<=board.length-1; i++) {
			for(int j=0; j<=board.length-1; j++) {
				board[i][j] = '.';
				
							
			}
		}
	}

}
