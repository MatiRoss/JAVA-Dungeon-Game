package equipments;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import game.Cell;

/**
 * Class that represents a spell Fireball.
 * Inherits from the class Weapons
 *
 * @see Weapons
 */
public class Fireball extends Weapons {

    /**
     * Fireball Constructor.
     * Sets the attributes of the item
     */
    public Fireball() {
        super("Sort : Boule de feu", 7);
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
        if (player instanceof Warrior) {
            System.out.println("... Mais vous êtes un barbare... Vous ne comprenez rien à la magie!");
            System.out.println(" ---------------------------------------------------");
        } else {
            player.getInventory().setInventory(cell);
        }
    }
}
