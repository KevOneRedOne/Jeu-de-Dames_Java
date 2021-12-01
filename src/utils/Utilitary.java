package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import models.Pion;
import models.Score;

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
	
	public static void CreateFile(String fileToBeCreated){
		File file = new File(fileToBeCreated);
		if (file.exists() && fileToBeCreated != "classement.txt") {
			file.delete();
		}
	}
	
	public static void RemoveContentFromFile(String targetedFile) {
		
	}
	
	public static void WriteStringToFile(String data) throws IOException {
		FileWriter fw = new FileWriter("etatPartie.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(data);
		bw.close();
	}
	
	public static void WriteScoreBoard(ArrayList<Score> ListScore) throws IOException {
		FileWriter fw = new FileWriter("classement.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		Collections.sort(ListScore, Collections.reverseOrder());
		String scoreboard = ListScore.toString();
		bw.write(scoreboard);
		bw.close();
	}
	
	public static void WriteLastGameScoreToFile(Score winner, Score loser) throws IOException{
		FileWriter fw = new FileWriter("score.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Le gagnant de la dernière partie est : " + winner.getPlayerName() + " - Victoires : " + winner.getNbVictories() + " - Défaites : " + winner.getNbDefeats() + " - Score : " + winner.getScore()
		+ "\n\nLe perdant est : " + loser.getPlayerName() + " - Victoires : " + loser.getNbVictories() + " - Défaites : " + loser.getNbDefeats() + " - Score : " + loser.getScore());
		bw.close();
	}
	
	public static void WriteBoardToFile(char[][] myBoard) throws IOException {
		StringBuilder builder = new StringBuilder();
		FileWriter fw = new FileWriter("etatPartie.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		int counter = 0;
		bw.newLine();
		bw.write(" --0---1---2---3---4---5---6---7---8---9--");
		for (int i = 0; i < myBoard.length; i++) {
			bw.write("\n");
			for (int j = 0; j < myBoard[i].length; j++) {
				bw.write(" | " + myBoard[i][j]);
				builder.append(myBoard[i][j]+ "");

			}
			bw.write(" | "+ counter + "\n");
			bw.write(" -----------------------------------------");
			counter++;
		}
		bw.newLine();
		bw.close();
	}
}