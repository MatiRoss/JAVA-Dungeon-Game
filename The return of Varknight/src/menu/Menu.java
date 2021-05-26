package menu;

import java.sql.SQLException;
import java.util.Scanner;

import characters.*;
import characters.Character;
import database.Database;

/**
 * Class that represents the game menu.
 * It has 2 attributes :
 * - player (of type Character) that represents the current player.
 *
 * @see Character
 * - keyboard (of type Scanner) that allows the player to type throughout the menu.
 * @see Scanner
 */
public class Menu {
    private Character player;
    private final Scanner keyboard;
    private MenuText text;

    /**
     * Menu Constructor.
     * It sets the player attribute to null by default and instantiate a Scanner type object.
     */
    public Menu() {
        this.player = null;
        this.keyboard = new Scanner(System.in);
    }

    /**
     * Method that instantiate a type of character (Warrior or Wizard) according to player's choice.
     * Using Scanner class, player can choose the name of their character
     *
     * @see Warrior
     * @see Wizard
     */
    public void characterSelection() throws SQLException, ClassNotFoundException {
        Database database = new Database();
        text = new MenuText();

        text.launchMenu();
        text.characterSelection();
        int characterChoice = keyboard.nextInt();
        if (characterChoice == 1) {
            createNewCharacter();
            database.insertNewHero(player);
        } else if (characterChoice == 2) {
            database.displayHeroes();
            database.loadHero(player);
        } else {
            System.exit(0);
        }
        text.launchGame();
    }

    public Character getPlayer() {
        return player;
    }

    public void createNewCharacter() {
        text.characterCreation();
        boolean choice = true;
        while (choice) {
            int playerCharacter = keyboard.nextInt();
            if (playerCharacter == 1) {
                text.nameChoice();
                String playerName = keyboard.next();
                if (playerName.equals("q")) {
                    System.exit(0);
                }
                System.out.println("");
                System.out.println("Votre personnage s'appelera " + playerName + ", êtes-vous sûr(e) de votre choix?");
                text.checkName();
                String playerChoice = keyboard.next();
                switch (playerChoice) {
                    case "o": {
                        player = new Warrior(playerName);
                        System.out.println(player.descriptionWarrior());
                        text.whiteSpace();
                        break;
                    }
                    case "n": {
                        text.finalName();
                        String playerName2 = keyboard.next();
                        player = new Warrior(playerName2);
                        System.out.println(player.descriptionWarrior());
                        text.whiteSpace();
                        break;
                    }
                    case "q": {
                        System.exit(0);
                    }
                }
                choice = false;
            } else if (playerCharacter == 2) {
                text.nameChoice();
                String playerName = keyboard.next();
                if (playerName.equals("q")) {
                    System.exit(0);
                }
                System.out.println("Votre personnage s'appelera " + playerName + ", êtes-vous sûr(e) de votre choix?");
                text.checkName();
                String playerChoice = keyboard.next();
                switch (playerChoice) {
                    case "o": {
                        player = new Wizard(playerName);
                        System.out.println(player.descriptionWizard());
                        text.whiteSpace();
                        break;
                    }
                    case "n": {
                        text.finalName();
                        String playerName2 = keyboard.next();
                        player = new Wizard(playerName2);
                        System.out.println(player.descriptionWizard());
                        text.whiteSpace();
                        break;
                    }
                    case "q": {
                        System.exit(0);
                    }
                }
                choice = false;
            } else if (playerCharacter == 3) {
                System.exit(0);
            } else {
                System.out.println("Veuillez taper 1,2 ou 3 et pas autre chose!!");
            }
        }
    }
}
