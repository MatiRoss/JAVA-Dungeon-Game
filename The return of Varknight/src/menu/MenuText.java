package menu;

/**
 * Class that uses different methods to display different types of text throughout the game.
 */
public class MenuText {

    public void launchMenu() {
        System.out.println("");
        System.out.println(" _____________________________________________________________________________________");
        System.out.println("|___|___|___|___|___| Bienvenue dans D&D: THE RETURN OF VARKNIGHT |___|___|___|___|___|");
        System.out.println("");
        System.out.println("");
        System.out.println("CREATION DU PERSONNAGE");
        System.out.println(" ________________________________________");
        System.out.println("Quelle personnage souhaitez-vous incarner?");
        System.out.println(" ----------------------------------------");
        System.out.println("");
        System.out.println("[1] Guerrier");
        System.out.println("[2] Magicien");
        System.out.println("[3] Quitter le jeu");
        System.out.println("");
    }

    public void nameChoice() {
        System.out.println("");
        System.out.println(" ________________________________________");
        System.out.println("Veuillez saisir le nom de votre personnage");
        System.out.println(" ----------------------------------------");
        System.out.println("(ou tapez 'q' pour quitter le jeu)");
        System.out.println("");
    }

    public void checkName() {
        System.out.println(" ____________________________________________________________________");
        System.out.println("(Taper 'o' pour confirmer, 'n' pour modifier ou 'q' pour quitter le jeu)");
        System.out.println("");
    }

    public void finalName() {
        System.out.println("");
        System.out.println("Veuillez taper le nom (définitif!) de votre personnage");
        System.out.println("");
    }

    public void whiteSpace() {
        System.out.println("");
        System.out.println("");
    }

    public void displayInventory() {
        System.out.println("(Ouvrir l'inventaire      ('i')");
        System.out.println("");
    }

    public void launchGame() {
        System.out.println("______________________________________");
        System.out.println("Préparez-vous à vivre une aventure...");
        System.out.println("         ...pas si palpitante que ça.");
        System.out.println("--------------------------------------");
    }

    public void rollDice() {
        System.out.println("----------------------------------------------------");
        System.out.println("Lancer le dé?           OUI ('o')          NON ('n')");
        System.out.println("----------------------------------------------------");

    }

    public void FightOrFlee() {
        System.out.println("----------------------------------------------------");
        System.out.println("[1] Attaquer         [2] Fuir         [3] Inventaire");
        System.out.println("----------------------------------------------------");
    }

    public void youWin() {
        System.out.println("");
        System.out.println("Vous avez atteint la sortie.");
        System.out.println("________________________");
        System.out.println("Bravo vous avez gagné!");
        System.out.println("------------------------");
    }

    public void youLose() {
        System.out.println("________________________");
        System.out.println("    Vous avez perdu!");
        System.out.println("------------------------");
    }
}






