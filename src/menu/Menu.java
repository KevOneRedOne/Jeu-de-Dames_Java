package menu;

import utils.Utilitary;
import game.Game;

public class Menu {

	public static void MenuPrincipal() {
		boolean isGameOn = true;
		System.out.print("Bonjour !\nBienvenue dans notre jeu de Dames en invite de commande !\nQue souhaitez-vous faire ?\n");
		
		do {
			System.out.println("1 - Jouer contre l'ordinateur.");
			System.out.println("2 - Jouer contre un autre joueur.");
			System.out.println("3 - Voir les scores.");
			System.out.println("4 - Quitter le jeu !");
		
			switch (Utilitary.inputUsers()) {
			case "1":
				Game.createPieceIA();
				Game.createPiecePlayer1();
				System.out.println("Quel est le nom du joueur ?");
				String name = Utilitary.inputUsers();
				System.out.println("Nom joueur " + name);
				break;
				
			case "2":
				Game.createPiecePlayer1();
				System.out.println("Quel est le nom du joueur 1 ?");
				String name1 = Utilitary.inputUsers();
				System.out.println("Nom joueur 1 " + name1);
				Game.createPiecePlayer2();
				System.out.println("Quel est le nom du joueur 2 ?");
				String name2 = Utilitary.inputUsers();
				System.out.println("Nom joueur 2 " + name2);				
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
