package menu;

import utils.Utilitary;
import java.io.IOException;
import java.util.ArrayList;
import game.Game;
import models.Pion;

public class Menu {
	
	public static void MenuPrincipal(ArrayList<Pion> PlayerPionJ1, ArrayList<Pion> PlayerPionJ2, char[][] board) {
		boolean isGameOn = true;
		boolean NotGamerOver = true;
		int tour = 1;
		System.out.println("Bonjour !\nBienvenue dans notre jeu de Dames en invite de commande !");
		System.out.println("Que souhaitez-vous faire ?\n");
		try {
			Utilitary.CreateFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Game.createPiecePlayer1(PlayerPionJ1);
		Game.createPiecePlayer2(PlayerPionJ2);
		
		do {
			System.out.println("1 - Jouer contre l'ordinateur.");
			System.out.println("2 - Jouer contre un autre joueur.");
			System.out.println("3 - Voir les scores.");
			System.out.println("4 - Quitter le jeu !");
		
			switch (Utilitary.inputUsers()) {
			case "1":
				System.out.println("Quel est le nom du joueur ?");
				String PlayerName = Utilitary.inputUsers();
				
				if ( PlayerName == null || PlayerName =="") {
					PlayerName = "Joueur 1";
				}
				System.out.println("\nBonjour " + PlayerName);
				System.out.println("\nPour jouer :\nSelectionnez les coordonn�es X et Y du pion que vous voulez jouer !\nPuis indiquez la case ou vous voulez mettre votre pi�ce, toujours avec des coordon�es !\n");
				while (NotGamerOver) {
					board = Game.FillCheckers(PlayerPionJ1, PlayerPionJ2);
					Utilitary.printMap(board);
					System.out.println("\nTour : "+ tour + "\n" + PlayerName + ", vous avez les pions : O " );
					System.out.println("L'adversaire poss�de les pions : X ");
					System.out.println("\nChoisissez votre pi�ce :");
					Game.MovePiecePlayer(PlayerPionJ1, PlayerPionJ2);
					System.out.println("Tour : "+ tour + "\n"+ "L'ordinateur joue !" );
//					TODO Function MovePieceIA, Work in progress..
					Game.MovePieceIA(PlayerPionJ2);

//					TODO Faire fonction pour prendre un pion
					
					Utilitary.CheckGameOver(NotGamerOver, PlayerPionJ1, PlayerPionJ2);
					tour++;
					try {
						Utilitary.WriteBoardToFile(board);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				break;
				
			case "2":
				try {
					Utilitary.CreateFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Quel est le nom du joueur 1 ?");
				String Player1Name = Utilitary.inputUsers();
				System.out.println("Quel est le nom du joueur 2 ?");
				String Player2Name = Utilitary.inputUsers();

				if ( Player1Name == null || Player1Name =="") {
					Player1Name = "Joueur 1";
				}
				if ( Player2Name == null || Player2Name =="") {
					Player2Name = "Joueur 2";
				}
				System.out.println("\nBonjour " + Player1Name + " et " + Player2Name + " !");
				System.out.println("\nPour jouer :\nSelectionnez les coordonn�es X et Y du pion que vous voulez jouer !\nPuis indiquez la case ou vous voulez mettre votre pi�ce, toujours avec des coordon�es !\n");
				while (NotGamerOver) {
					board = Game.FillCheckers(PlayerPionJ1, PlayerPionJ2);
					Utilitary.printMap(board);
					System.out.println("\nTour : "+ tour + "\n" + Player1Name + ", vous avez les pions : O " );
					System.out.println(Player2Name + ", vous avez les pions : X ");
					System.out.println("\n"+ Player1Name+" choisissez votre pi�ce :");
					Game.MovePiecePlayer(PlayerPionJ1, PlayerPionJ2);
					board = Game.FillCheckers(PlayerPionJ1, PlayerPionJ2);
					Utilitary.printMap(board);
					System.out.println("\n"+ Player2Name+" choisissez votre pi�ce :");
					Game.MovePiecePlayer(PlayerPionJ2, PlayerPionJ1);
//					TODO Faire fonction pour verifier la case suivante
//					TODO Faire fonction pour prendre un pion
					
					Utilitary.CheckGameOver(NotGamerOver, PlayerPionJ1, PlayerPionJ2);
					tour++;
					try {
						Utilitary.WriteBoardToFile(board);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				break;
				
			case "3":
				break;
				
			case "4": 
				isGameOn = false;
				System.out.println("Au revoir !");
				break;	
			}
		} while (isGameOn);
		
	}
}
