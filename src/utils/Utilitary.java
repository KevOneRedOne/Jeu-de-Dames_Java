package utils;

import java.util.ArrayList;
import java.util.Scanner;

import models.Pion;

public class Utilitary {
	
	public static void printMap(char[][] board) {
		System.out.println();
		int counter = 0;
		System.out.println(" --0---1---2---3---4---5---6---7---8---9--");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(" | " + board[i][j]);
			}
			System.out.println(" | "+ counter);
			System.out.println(" -----------------------------------------");
			counter++;
		}
	}
	
	public static boolean CheckGameOver(boolean NotGameOver, ArrayList<Pion> PlayerPionJ1, ArrayList<Pion> PlayerPionJ2) {
		if (PlayerPionJ1 == null || PlayerPionJ2 == null) {
			NotGameOver = false ;
		}
		NotGameOver = true;
		return NotGameOver;
			
	}
	
	
	public static String inputUsers(){
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	return s;
	}
	
	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try {
			i = sc.nextInt();
		}
		catch(Exception e) {
		}
		return i;
	}
}