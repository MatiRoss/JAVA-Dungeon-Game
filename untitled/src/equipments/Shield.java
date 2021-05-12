package equipments;

import characters.Character;
import characters.Wizard;
import game.Cell;

/**
 * Class that represents a defensive item Shield.
 * Inherits from the class Protections
 *
 * @see Protections
 */
public class Shield extends Protections {

    /**
     * Shield Constructor.
     * Sets the attributes of the item
     */
    public Shield() {
        super("Bouclier", 5);
    }

    /**
     * Method inherited from parent Cell.
     * Handles the interaction between the item and the player.
     * It takes 2 parameters :
     *
     * @param player refers to the current player
     * @param cell   refers to the cell the player is currenty on
     * @see Character
     * @see Cell
     */
    @Override
    public void interaction(Character player, Cell cell) {
        if (player instanceof Wizard) {
            System.out.println("... Mais vous êtes un magicien, vous n'avez pas même pas la force de le soulever!");
            System.out.println(" ---------------------------------------------------");
        } else {
            player.getInventory().setInventory(cell);
        }
    }
}
