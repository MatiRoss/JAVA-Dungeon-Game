package enemies;

/**
 * Class that represents one type of Enemy (Dragon). It inherits from the parent archetype class Enemy.
 */
public class Dragon extends Enemy {

    /**
     * Dragon Constructor with no parameters required.
     * It has pre a set of attributes (declared previously in its parent's class Enemy)
     * @see Enemy
     */
    public Dragon() {
        super("Dragon", 15, 5, false);
    }
}
