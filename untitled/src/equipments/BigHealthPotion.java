package equipments;

import characters.Character;
import game.Cell;

/**
 * Class that represents a big potion.
 * It has 2 attributes :
 * - 'name' : the name of item
 * - 'health' : an integer that represents the amount of health that the potion gives to the player
 */
public class BigHealthPotion extends Cell {
    String name;
    int health;

    /**
     * BigHealthPotion Constructor.
     * Sets the attributes of the item
     */
    public BigHealthPotion() {
        this.health = 5;
        this.name = "Grande potion de soin";
    }

    /**
     * Method inherited from parent Cell.
     * Handles the interaction between the item and the player.
     * It takes 2 parameters :
     *
     * @param player refers to the current player
     * @param cell   refers to the cell the player is currenty on
     * @see Cell
     */
    @Override
    public void interaction(Character player, Cell cell) {
        player.getInventory().setInventory(cell);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int power) {
        this.health = power;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(+" + health + " PV)" + '\n';
    }

    public String eventDescription() {
        return "Vous tombez sur un coffre. Vous l'ouvrez..." + '\n' + "Wow quelle chance! Vous avez trouvé une " + name + "! Elle rend " + health + " points de vie.";
    }
}
