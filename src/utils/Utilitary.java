package utils;

import java.util.Scanner;

public class Utilitary {
	
	public static void printMap(char[][] mapToRead) {
		System.out.println(" -----------------------------------------");
		for (int i = 0; i < mapToRead.length; i++) {
			for (int j = 0; j < mapToRead.length; j++) {
				System.out.print(" | " + mapToRead[j][i]);
			}
			System.out.println(" | ");
			System.out.println(" -----------------------------------------");
		}
	}
	
	public static void fillBoard(char[][] CheckersBoard) {
		for(int i=0; i<=CheckersBoard.length-1; i++) {
			for(int j=0; j<=CheckersBoard.length-1; j++) {
				CheckersBoard[i][j] = ' ';	
//				CheckersBoard[i][0] = '' ;
//				CheckersBoard[i][CheckersBoard[i].length-1]='|';
//				CheckersBoard[0][j] = '|' ;
//				CheckersBoard[CheckersBoard[i].length-1][j]='|';
			}
		}
	}
	
	public static String inputUsers(){
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	return s;
	}
}
