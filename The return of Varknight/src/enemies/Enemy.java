package enemies;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import game.*;
import menu.MenuText;

/**
 * Class that represents the enemy archetype. It extends Cell as it can be found on the game board's cells.
 * It has 5 attributes :
 * - 'name' refers to the enemy's name
 * - 'picture' refers to the enemy's picture (unused)
 * - 'hp' refers to enemy's health points
 * - 'attack' refers to the damage an enemy can inflict
 * - 'isDead' is a boolean attribute that lets you verify if enemy is dead or not
 */
public class Enemy extends Cell {

    private String name;
    private String picture;
    private int hp;
    private int attack;
    private boolean isDead;

    public Enemy() {
    }

    /**
     * Enemy Constructor that requires only the name as a parameter.
     *
     * @param name;
     */
    public Enemy(String name) {
        this.name = name;
    }

    /**
     * Enemy Constructor that requires all the parameters below :
     *
     * @param name;
     * @param hp;
     * @param attack;
     * @param isDead;
     */
    public Enemy(String name, int hp, int attack, boolean isDead) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.isDead = isDead;
    }

    /**
     * Overridden method inherited from Cell that handles the interaction between the player and the enemy on a specific cell.
     * It calculates how much damage the player inflict and/or receive and does the same for the enemy.
     * It takes 2 parameters :
     *
     * @param player : the current player
     * @param cell   : the actual cell containing the enemy
     * @see Cell#interaction(Character, Cell)
     */
    @Override
    public void interaction(Character player, Cell cell) {
        for (int tour = 1; !isDead; tour++) {
        if (((Enemy) cell).getHp() > 0 && player.getHp() > 0) {

                System.out.println("TOUR " + tour);
                tour++;
                player.playerAttack(player, (Enemy) cell);

                if (((Enemy) cell).getHp() > 0) {
                    if (player instanceof Warrior) {
                        if (((Warrior) player).getProtection() != null) {
                            System.out.println("TOUR " + tour);
                            enemyAttackShield(player);
                        } else {
                            System.out.println("TOUR " + tour);
                            ennemyAttack(player);
                        }
                    } else if (player instanceof Wizard) {
                        if (((Wizard) player).getProtection() != null) {
                            System.out.println("TOUR " + tour);
                            enemyAttackPhilter(player);
                        } else {
                            System.out.println("TOUR " + tour);
                            ennemyAttack(player);
                        }
                    }
                }
            }
        }
    }

    public void enemyAttackPhilter(Character player) {
        System.out.println("_______________________________________________________");
        System.out.println("Le " + getName() + " vous attaque... mais votre philtre vous protège!");
        System.out.println("Le " + getName() + " inflige " + getAttack() + " points de dégats à votre armure magique.");
        ((Wizard) player).getProtection().setDefense(((Wizard) player).getProtection().getDefense() - getAttack());
        if (((Wizard) player).getProtection().getDefense() > 0) {
            System.out.println("Votre philtre vous permet d'encaisser encore " + ((Wizard) player).getProtection().getDefense() + " points de dégats.");
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("L'effet du philtre se dissipe!");
            System.out.println("----------------------------------------------------");
            ((Wizard) player).setProtection(null);
        }
    }

    public void enemyAttackShield(Character player) {
        System.out.println("_______________________________________________________");
        System.out.println("Le " + getName() + " vous attaque... mais vous parez le coup avec votre bouclier!");
        ((Warrior) player).getProtection().setDefense(((Warrior) player).getProtection().getDefense() - getAttack());
        System.out.println("Le " + getName() + " inflige " + getAttack() + " points de dégats à votre bouclier.");
        if (((Warrior) player).getProtection().getDefense() > 0) {
            System.out.println("Il peut encore encaisser " + ((Warrior) player).getProtection().getDefense() + " points de dégats.");
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Le " + getName() + " a détruit votre bouclier!");
            System.out.println("----------------------------------------------------");
            ((Warrior) player).setProtection(null);
        }
    }

    public void ennemyAttack(Character player) {
        MenuText text = new MenuText();
        System.out.println("_______________________________________________________");
        System.out.println("Le " + getName() + " vous attaque et vous inflige " + getAttack() + " points de dégats");
        player.setHp(player.getHp() - getAttack());
        if (player.getHp() <= 0) {
            System.out.println('\n' + "Le " + getName() + " vous porte un coup fatal...");
            System.out.println("...vous mourrez dans d'atroces souffrances.");
            text.youLose();
        } else {
            System.out.println("Il vous reste " + player.getHp() + " points de vie.");
            System.out.println("----------------------------------------------------");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String showStats() {
        return getName() + " ==>  PV : " + getHp() + " || ATK : " + getAttack();
    }

    @Override
    public String toString() {
        return "Vous tombez sur un " + name + ", il a " + hp + " points de vie et " + attack + " d'attaque.";
    }

    @Override
    public String eventDescription() {
        return "Vous tombez sur un " + name + ", il a " + hp + " points de vie et " + attack + " d'attaque.";
    }
}
