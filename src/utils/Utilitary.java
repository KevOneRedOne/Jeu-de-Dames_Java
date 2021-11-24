package utils;

import java.util.Scanner;

public class Utilitary {
	
	public static void printMap(char[][] mapToRead) {
		System.out.println();
		int counter = 0;
		System.out.println(" --0---1---2---3---4---5---6---7---8---9--");
		for (int i = 0; i < mapToRead.length; i++) {
			for (int j = 0; j < mapToRead.length; j++) {
				System.out.print(" | " + mapToRead[j][i]);
			}
			System.out.println(" | "+ counter);
			System.out.println(" -----------------------------------------");
			counter++;
		}
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