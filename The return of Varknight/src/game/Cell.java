package game;

import characters.Character;

/**
 * Abstract class that is used as a parent for all the type of things you can find on a specific game board's cell.
 * Children of this class listed below as a reference :
 *
 * @see enemies.Enemy
 * @see equipments.Weapons
 * @see equipments.Protections
 * @see equipments.HealthPotion
 * @see equipments.BigHealthPotion
 */
public abstract class Cell {

    public Cell() {
    }

    /**
     * Abstract method that lets you manage how to interact with the object on a specific cell.
     *
     * @param player refers to the current player
     * @param cell   refers to the cell the player is currenty on
     */
    public abstract void interaction(Character player, Cell cell);

    /**
     * Abstract method displaying a short description (text).
     *
     * @return description of the object encountered on a specific cell.
     */
    public abstract String eventDescription();

}

