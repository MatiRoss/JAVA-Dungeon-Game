package equipments;

import game.Cell;

/**
 * Class that represents the archetype of defensive items.
 * It inherits from Cell
 * It has 2 attributes :
 * 'name' : the name of the item
 * 'defense' : an integer that represents the amount of damage that can be blocked/cancelled by the player
 *
 * @see Shield
 * @see Philter
 */
public abstract class Protections extends Cell {
    String name;
    int defense;

    public Protections() {
    }

    public Protections(String name) {
        this.name = name;
    }

    public Protections(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return getName() + "(+" + getDefense() + " DEF)" + '\n';
    }

    public String eventDescription() {
        return "Vous tombez sur un coffre. Vous l'ouvrez..." + '\n' + "Wow quelle chance, vous avez trouvé un " + name + "! Il bloque " + defense + " points de dégats.";
    }
}
