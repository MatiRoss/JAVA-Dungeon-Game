package enemies;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

/**
 * Class that represents one type of Enemy (Goblin King). It inherits from the parent archetype class Enemy.
 */
public class GoblinKing extends Enemy {
    private boolean stuns;

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
        stuns = false;
        int dice = player.throwDice();
        if (dice == 1 || dice == 2) {
            stuns = true;
            System.out.println("_______________________________________________________");
            System.out.println("Le " + getName() + " vous écrase son marteau sur la tête!");
            System.out.println("Vous êtes étourdi... Vous ne pourrez pas attaquer au prochain tour.");
        }
        if (player instanceof Warrior) {
            if (((Warrior) player).getProtection() != null) {
                enemyAttackShield(player);
            } else {
                enemyAttack(player);
            }
        } else if (player instanceof Wizard) {
            if (((Wizard) player).getProtection() != null) {
                enemyAttackPhilter(player);
            } else {
                enemyAttack(player);
            }
        }
    }

    public boolean hasStunned() {
        return stuns;
    }
}


