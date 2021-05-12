package equipments;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import game.Cell;

/**
 * Class that represents a club.
 * Inherits from the class Weapons
 *
 * @see Weapons
 */

public class Club extends Weapons {

    /**
     * Bow Constructor.
     * Sets the attributes of the item
     */
    public Club() {
        super("Massue", 3);
    }

    /**
     * Method inherited from parent Cell.
     * Handles the interaction between the item and the player.
     * It takes 2 parameters :
     *
     * @param player refers to the current player
     * @param cell   refers to the cell the player is currenty on
     */
    @Override
    public void interaction(Character player, Cell cell) {
        if (player instanceof Wizard) {
            System.out.println("... Mais vous êtes un magicien, les armes c'est pour les barbares!");
            System.out.println(" ---------------------------------------------------");
        } else {
            player.getInventory().setInventory(cell);
        }
    }
}
