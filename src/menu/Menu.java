package menu;

import utils.Utilitary;
import java.util.ArrayList;
import game.Game;
import models.Pion;

public class Menu {
	
	public static void MenuPrincipal(ArrayList<Pion> PionPlayer1, ArrayList<Pion> PionPlayer2, char[][] board) {
		boolean isGameOn = true;
		boolean NotGamerOver = true;
		int tour = 1;
		System.out.print("Bonjour !\nBienvenue dans notre jeu de Dames en invite de commande !\nQue souhaitez-vous faire ?\n");
		
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
				System.out.println("\nPour jouer :\nSelectionnez les coordonnées X et Y du pion que vous voulez jouer !\nPuis indiquez la case ou vous voulez mettre votre pièce, toujours avec des coordonées !\n");
				while (NotGamerOver) {
					Game.createPiecePlayer1();
					Game.createPiecePlayer2();
					Game.FillCheckers(PionPlayer1, PionPlayer2, board);
					Utilitary.printMap(board);
					System.out.println("Tour : "+ tour + "\n" + PlayerName + ", vous avez les pions : O " );
					System.out.println("L'adversaire possède les pions : X ");
//					System.out.println("Abscisse X de votre pièce (Entre 0 et 9) : ");
//					int readCoordonneeX = Utilitary.readInt(); 
//					System.out.println("Ordonnée Y de votre pièce (Entre 0 et 9) : ");
//					int readCoordonneeY = Utilitary.readInt(); 
//					System.out.println("Vous avez choisi la pièce aux coordonnées : " + readCoordonneeX + ","+ readCoordonneeY);
//					TODO Faire fonction de mouvement 
					Game.MovePiecePlayer1();
					NotGamerOver = false;
				}
//				Utilitary.printMap(board);
				break;
				
			case "2":
			
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
