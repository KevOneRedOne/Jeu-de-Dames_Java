package menu;

import utils.Utilitary;

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
