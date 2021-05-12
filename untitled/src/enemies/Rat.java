package enemies;

/**
 * Class that represents one type of Enemy (Rat). It inherits from the parent archetype class Enemy.
 */
public class Rat extends Enemy {

    /**
     * Rat Constructor with no parameters required.
     * It has pre a set of attributes (declared previously in its parent's class Enemy)
     * @see Enemy
     */
    public Rat() {
        super("Rat", 1, 1, false);
    }

    @Override
    public String toString() {
        return "Vous retombez sur le cadavre de l'ennemi que vous avez tué. Il est cerné par les rats." + '\n' + "Attention, il y en a qui vous attaque!";
    }
}
