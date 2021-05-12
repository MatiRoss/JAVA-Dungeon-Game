package enemies;

/**
 * Class that represents one type of Enemy (Sorcerer). It inherits from the parent archetype class Enemy.
 */
public class Sorcerer extends Enemy {

    /**
     * Sorcerer Constructor with no parameters required.
     * It has pre a set of attributes (declared previously in its parent's class Enemy)
     * @see Enemy
     */
    public Sorcerer() {
        super("Sorcerer", 9, 2, false);
    }
}
