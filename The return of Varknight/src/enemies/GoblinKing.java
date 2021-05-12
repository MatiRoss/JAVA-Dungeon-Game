package enemies;

/**
 * Class that represents one type of Enemy (Goblin King). It inherits from the parent archetype class Enemy.
 */
public class GoblinKing extends Enemy{

    /**
     * GoblinKing Constructor with no parameters required.
     * It has pre a set of attributes (declared previously in its parent's class Enemy)
     * @see Enemy
     */
    public GoblinKing(){
        super("Roi Gobelin", 30,2, false);
    }
}
