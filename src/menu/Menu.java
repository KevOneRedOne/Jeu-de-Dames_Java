package menu;

import utils.Utilitary;
import java.io.IOException;
import java.util.ArrayList;

import game.Game;
import models.Pion;
import models.Score;

public class Menu {
	
	public static void MenuPrincipal(ArrayList<Pion> PlayerPionJ1, ArrayList<Pion> PlayerPionJ2, char[][] board) {
		boolean isGameOn = true;
		boolean NotGamerOver = true;
		int tour = 1;
		ArrayList<Score> ListWinner = new ArrayList<Score>();
		ArrayList<Score> ListLoser = new ArrayList<Score>();
		
		Score Winner = new Score("Test", 0, 0, 0);
		Score Loser = new Score("Test", 0, 0, 0);
		System.out.println("Bonjour !\nBienvenue dans notre jeu de Dames en invite de commande !");
		System.out.println("Que souhaitez-vous faire ?\n");
		Utilitary.CreateFile("etatPartie.txt");
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
				try {
					Utilitary.WriteStringToFile("Nom du joueur : "+ PlayerName + "\n\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("\nBonjour " + PlayerName);
				System.out.println("\nPour jouer :\nSelectionnez les coordonnées X et Y du pion que vous voulez jouer !\nPuis indiquez la case ou vous voulez mettre votre pièce, toujours avec des coordonées !\n");
				while (NotGamerOver) {
					board = Game.FillCheckers(PlayerPionJ1, PlayerPionJ2);
					Utilitary.printMap(board);
					System.out.println("\nTour : "+ tour + "\n" + PlayerName + ", vous avez les pions : O " );
					System.out.println("L'adversaire possède les pions : X ");
					System.out.println("\nChoisissez votre pièce :");
					Game.MovePiecePlayer(PlayerPionJ1, PlayerPionJ2);
					System.out.println("Tour : "+ tour + "\n"+ "L'ordinateur joue !" );
//					TODO Function MovePieceIA, Work in progress..
					Game.MovePieceIA(PlayerPionJ2);

//					TODO Faire fonction pour prendre un pion
					
					Utilitary.CheckGameOver(NotGamerOver, PlayerPionJ1, PlayerPionJ2);
					try {
						Utilitary.WriteStringToFile("Tour " + (tour-1) + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
					tour++;
					try {
						Utilitary.WriteBoardToFile(board);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//Tester si le score et la fin de partie fonctionnent
					if (tour == 5) {
						NotGamerOver = false;
					}
					if (NotGamerOver == false) {
						if (PlayerPionJ1 == null) {
							Winner.setPlayerName("Ordinateur");
							Winner.setNbVictories(+1);
							Winner.setScore(+1000);
							Loser.setPlayerName(PlayerName);
							Loser.setNbDefeats(+1);
							Loser.setScore(-1000);
							if (ListWinner.contains(Winner) == false) {
								ListWinner.add(Winner);
							}
							if (ListLoser.contains(Loser) == false) {
								ListLoser.add(Loser);
							}
							System.out.println("Le gagnant de la partie est l'Ordinateur");
							try {
								Utilitary.WriteStringToFile("Le gagnant de la partie est l'Ordinateur");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						else {
							Winner.setPlayerName(PlayerName);
							Winner.setNbVictories(+1);
							Winner.setScore(+1000);
							Loser.setPlayerName("Ordinateur");
							Loser.setNbDefeats(+1);
							Loser.setScore(-1000);
							if (ListWinner.contains(Winner) == false) {
								ListWinner.add(Winner);
							}
							if (ListLoser.contains(Loser) == false) {
								ListLoser.add(Loser);
							}
							System.out.println("Le gagnant de la partie est " + PlayerName);
							try {
								Utilitary.WriteStringToFile("Le gagnant de la partie est " + PlayerName);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
				break;
				
			case "2":
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
				System.out.println("\nPour jouer :\nSelectionnez les coordonnées X et Y du pion que vous voulez jouer !\nPuis indiquez la case ou vous voulez mettre votre pièce, toujours avec des coordonées !\n");
				while (NotGamerOver) {
					board = Game.FillCheckers(PlayerPionJ1, PlayerPionJ2);
					Utilitary.printMap(board);
					System.out.println("\nTour : "+ tour + "\n" + Player1Name + ", vous avez les pions : O " );
					System.out.println(Player2Name + ", vous avez les pions : X ");
					System.out.println("\n"+ Player1Name+" choisissez votre pièce :");
					Game.MovePiecePlayer(PlayerPionJ1, PlayerPionJ2);
					board = Game.FillCheckers(PlayerPionJ1, PlayerPionJ2);
					Utilitary.printMap(board);
					System.out.println("\n"+ Player2Name+" choisissez votre pièce :");
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
					//Tester si le score et la fin de partie fonctionnent
					if (tour == 5) {
						NotGamerOver = false;
					}
					if (NotGamerOver == false) {
						if (PlayerPionJ1 == null) {
							Winner.setPlayerName(Player2Name);
							Winner.setNbVictories(+1);
							Winner.setScore(+1000);
							Loser.setPlayerName(Player1Name);
							Loser.setNbDefeats(+1);
							Loser.setScore(-1000);
							if (ListWinner.contains(Winner) == false) {
								ListWinner.add(Winner);
							}
							if (ListLoser.contains(Loser) == false) {
								ListLoser.add(Loser);
							}
							System.out.println("Le gagnant de la partie est " + Player2Name);
							try {
								Utilitary.WriteStringToFile("Le gagnant de la partie est " + Player2Name);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						else {
							Winner.setPlayerName(Player1Name);
							Winner.setNbVictories(+1);
							Winner.setScore(+1000);
							Loser.setPlayerName(Player2Name);
							Loser.setNbDefeats(+1);
							Loser.setScore(-1000);
							if (ListWinner.contains(Winner) == false) {
								ListWinner.add(Winner);
							}
							if (ListLoser.contains(Loser) == false) {
								ListLoser.add(Loser);
							}
							System.out.println("Le gagnant de la partie est " + Player1Name);
							try {
								Utilitary.WriteStringToFile("Le gagnant de la partie est" + Player1Name);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					}
					
				}
				break;
				
			case "3":
				System.out.println("Que souhaitez vous faire ?" 
						+ "\n1 Regarder le classement par joueur (victoires défaites score) ?"
						+ "\n2 Regarder résultat de la dernière partie");
				switch(Utilitary.inputUsers()) {
				case "1":
					Utilitary.CreateFile("classement.txt");
					ListWinner.addAll(ListLoser);
					//TODO Régler l'erreur ClassCastException
					try {
						Utilitary.WriteScoreBoard(ListWinner);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;
				case "2":
					Utilitary.CreateFile("score.txt");
					//TODO Faire en sorte que Winner et Loser prennent les valeurs attribuées à la fin de la partie
					try {
						Utilitary.WriteLastGameScoreToFile(Winner, Loser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
				break;
				
			case "4": 
				isGameOn = false;
				System.out.println("Au revoir !");
				break;	
			}
		} while (isGameOn);
		
	}
}
