package enemies;

/**
 * Class that represents one type of Enemy (Goblin). It inherits from the parent archetype class Enemy.
 */
public class Goblin extends Enemy {

    /**
     * Goblin Constructor with no parameters required.
     * It has pre a set of attributes (declared previously in its parent's class Enemy)
     * @see Enemy
     */
    public Goblin() {
        super("Gobelin", 6, 1, false);
    }
}
