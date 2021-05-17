package enemies;

/**
 * Class that represents one type of Enemy (Goblin King). It inherits from the parent archetype class Enemy.
 */
public class GoblinKing extends Enemy {

    /**
     * GoblinKing Constructor with no parameters required.
     * It has pre a set of attributes (declared previously in its parent's class Enemy)
     *
     * @see Enemy
     */
    public GoblinKing() {
        super("Roi Gobelin", 30, 2, false);
    }

    public void stun(Character player) {
        int dice = 0;
        dice = (int) (Math.random() * 6 + 1);
        if (dice == 1 || dice == 2) {
            System.out.println("Le " + getName() + " vous écrase son marteau sur la tête!");
            System.out.println("Vous êtes étourdi... Vous ne pourrez pas attaquer au prochain tour");
        }
    }
}
