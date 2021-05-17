package characters;

import enemies.Enemy;
import equipments.*;
import menu.MenuText;

import java.util.Scanner;

/**
 * Abstract class that represents the character's archetype.
 * It has 9 attributes :
 * - 'name' refers to the player's name
 * - 'picture' refers to the player's picture (unused)
 * - 'hp' refers to the player's health points
 * - 'hpMin' refers to the minimum health points a player starts with
 * - 'hpMax' refers to the maximum health points a player can get to
 * - 'attack' refers to the damage the player can inflict
 * - 'attackMin' refers to the minimum damage a player starts with
 * - 'attackMax' refers to the maximum damage a player can inflict
 * - 'inventory' refers to the player's inventory where he can store objects
 *
 * @see Inventory
 */

public abstract class Character {

    private String name;
    private String picture;
    private int hp;
    private int hpMin;
    private int hpMax;
    private int attack;
    private int attackMin;
    private int attackMax;
    private Inventory inventory;

    public Character() {

    }

    /**
     * Character constructor that requires only the name as a parameter.
     *
     * @param name;
     */
    public Character(String name) {
        this.name = name;
    }

    /**
     * Character constructor that requires all the parameters below :
     *
     * @param name;
     * @param hp;
     * @param hpMin;
     * @param hpMax;
     * @param attack;
     * @param attackMin;
     * @param attackMax;
     * @param inventory;
     */
    public Character(String name, int hp, int hpMin, int hpMax, int attack, int attackMin, int attackMax, Inventory inventory) {
        this.name = name;
        this.hp = hp;
        this.hpMin = hpMin;
        this.hpMax = hpMax;
        this.attack = attack;
        this.attackMin = attackMin;
        this.attackMax = attackMax;
        this.inventory = new Inventory();

    }

    /**
     * Method that displays the inventory to the player as a list of all objects contained in the bag.
     * It takes one parameter :
     *
     * @param player : the current player
     */
    public void displayInventory(Character player) {
        System.out.println("Vous fouillez dans votre sac..." + '\n');
        for (int i = 0; i < player.getInventory().inventory.length; i++) {
            if (player.getInventory().inventory[i] == null) {
                System.out.println("[" + i + "] (Utiliser)" + "            <Vide>");
            } else {
                System.out.println("[" + i + "] (Utiliser)" + "            " + player.getInventory().inventory[i]);
            }
        }
        System.out.println("");
        System.out.println("[9] Retour");
        System.out.println("");
    }

    /**
     * Method that simulate a dice roll
     *
     * @return an integer between 1 and 6
     */
    public int throwDice() {
        int dice = 0;
        dice = (int) (Math.random() * 6 + 1);
        return dice;
    }

    /**
     * Method that allows the player to interact with objects in inventory.
     * When used, the item disappears from the inventory.
     * It requires one parameter :
     *
     * @param player : the current player
     */
    public void useItem(Character player) {
        MenuText text = new MenuText();
        Scanner keyboard = new Scanner(System.in);
        int usableItem = keyboard.nextInt();
        switch (usableItem) {
            case 0:
                Object weapon = player.getInventory().inventory[0];

                if (weapon instanceof Sword) {
                    if (player.getAttack() < player.getAttackMax()) {
                        if (!((Warrior) player).hasSword()) {
                            System.out.println("Vous vous équipez de l'arme.");
                            System.out.println("Vos dégats augmentent de " + (player.getAttackMax() - player.getAttack()) + " et passent à " + player.getAttackMax() + ".");
                            System.out.println(" ---------------------------------------------------");
                            player.setAttack(player.getAttackMax());

                        } else {
                            System.out.println("... Mais vous possédez déjà une " + ((Sword) weapon).getName() + "!");
                            System.out.println(" ---------------------------------------------------");
                            ((Warrior) player).setHasSword(true);
                        }
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de puissance d'attaque!");
                        System.out.println(" ---------------------------------------------------");
                    }
                    ((Warrior) player).setWeapon((new Sword()));

                    player.getInventory().inventory[0] = null;
                } else if (weapon instanceof Club) {
                    if (player.getAttack() < player.getAttackMax()) {
                        if (!((Warrior) player).hasClub()) {
                            System.out.println("Vous vous équipez de l'arme.");
                            player.setAttack(player.getAttackMin() + ((Club) weapon).getPower());

                            System.out.println("Vos dégats augmentent de " + ((Club) weapon).getPower() + " et passent à " + player.getAttack() + ".");
                            System.out.println(" ---------------------------------------------------");
                            ((Warrior) player).setHasClub(true);
                        } else {
                            System.out.println("... Mais vous possédez déjà une " + ((Club) weapon).getName() + "!");
                            System.out.println(" ---------------------------------------------------");
                        }
                        ((Warrior) player).setWeapon((new Club()));

                        player.getInventory().inventory[0] = null;
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de puissance d'attaque!");
                        System.out.println(" ---------------------------------------------------");
                    }
                } else if (weapon instanceof Fireball) {

                    if (player.getAttack() < player.getAttackMax()) {
                        if (!((Wizard) player).hasFireBall()) {
                            System.out.println("Vous lisez attentivement le livre de " + ((Fireball) weapon).getName() + "...");
                            System.out.println("... Vous avez appris le " + ((Fireball) weapon).getName() + "!");
                            System.out.println(" ---------------------------------------------------");
                            System.out.println("Vos dégats augmentent de " + (player.getAttackMax() - player.getAttack()) + " et passent à " + player.getAttackMax() + ".");
                            System.out.println(" ---------------------------------------------------");
                            player.setAttack(player.getAttackMax());
                            player.getInventory().inventory[0] = null;
                        } else {
                            System.out.println("... Mais vous possédez déjà le " + ((Fireball) weapon).getName() + "!");
                            System.out.println(" ---------------------------------------------------");
                            ((Wizard) player).setHasFireBall(true);
                        }
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de puissance d'attaque!");
                        System.out.println(" ---------------------------------------------------");

                        ((Wizard) player).setWeapon((new Fireball()));
                        player.getInventory().inventory[0] = null;
                    }
                } else if (weapon instanceof Thunderstrike) {
                    if (player.getAttack() < player.getAttackMax()) {
                        if (!((Wizard) player).hasThunderstrike()) {
                            System.out.println("Vous lisez attentivement le livre de " + ((Thunderstrike) weapon).getName() + "...");
                            System.out.println("... Vous avez appris le " + getName() + "!");
                            System.out.println(" ---------------------------------------------------");
                            player.setAttack(player.getAttackMin() + ((Thunderstrike) weapon).getPower());
                            player.getInventory().inventory[0] = null;
                            System.out.println("Vos dégats augmentent de " + ((Thunderstrike) weapon).getPower() + " et passent à " + player.getAttack() + ".");
                            System.out.println(" ---------------------------------------------------");
                            ((Wizard) player).setHasThunderstrike(true);

                        } else {
                            System.out.println("... Mais vous possédez déjà le " + ((Thunderstrike) weapon).getName() + "!");
                            System.out.println(" ---------------------------------------------------");
                        }
                        ((Wizard) player).setWeapon((new Thunderstrike()));

                        player.getInventory().inventory[0] = null;
                    } else {
                        System.out.println('\n' + "... Mais vous avez déjà atteint votre maximum de puissance d'attaque!");
                    }
                }
                break;


            case 1:
                Object protection = player.getInventory().inventory[1];
                if (protection instanceof Shield) {
                    ((Warrior) player).setProtection((new Shield()));
                    System.out.println("Vous vous équipez du bouclier.");
                    System.out.println("Votre défense passe à " + ((Warrior) player).getProtection().getDefense() + ".");
                    player.getInventory().inventory[1] = null;
                } else if (protection instanceof Philter) {
                    ((Wizard) player).setProtection((new Philter()));
                    System.out.println("Vous buvez le philtre de protection.");
                    System.out.println("Votre défense passe à " + ((Wizard) player).getProtection().getDefense() + ".");
                    player.getInventory().inventory[1] = null;
                }
                break;

            case 2:
                Object potion1 = player.getInventory().inventory[2];
                if (potion1 instanceof HealthPotion) {
                    if (player.getHp() < player.getHpMax()) {
                        System.out.println("Vous buvez la potion... Glouglou... hips!");
                        System.out.println("Vos points de vie augmentent de " + ((HealthPotion) potion1).getHealth() + "!");
                        System.out.println("----------------------------------------------------");
                        player.setHp(player.getHp() + ((HealthPotion) potion1).getHealth());
                        if (player.getHp() > player.getHpMax()) {
                            player.setHp(player.getHpMax());
                        }
                        System.out.println("Vous avez désormais " + player.getHp() + " points de vie.");
                        System.out.println("----------------------------------------------------");
                        player.getInventory().inventory[2] = null;
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de points de vie!");
                        System.out.println(" ---------------------------------------------------");
                    }
                }

                break;


            case 3:
                Object potion2 = player.getInventory().inventory[3];
                if (potion2 instanceof HealthPotion) {
                    if (player.getHp() < player.getHpMax()) {
                        System.out.println("Vous buvez la potion... Glouglou... hips!");
                        System.out.println("Vos points de vie augmentent de " + ((HealthPotion) potion2).getHealth() + "!");
                        System.out.println("----------------------------------------------------");
                        player.setHp(player.getHp() + ((HealthPotion) potion2).getHealth());
                        if (player.getHp() > player.getHpMax()) {
                            player.setHp(player.getHpMax());
                        }
                        System.out.println("Vous avez désormais " + player.getHp() + " points de vie.");
                        System.out.println("----------------------------------------------------");
                        player.getInventory().inventory[3] = null;
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de points de vie!");
                        System.out.println(" ---------------------------------------------------");
                    }
                }
                break;

            case 4:
                Object bigPotion1 = player.getInventory().inventory[4];
                if (bigPotion1 instanceof BigHealthPotion) {
                    if (player.getHp() < player.getHpMax()) {
                        System.out.println("Vous buvez la potion... Glouglou... hips!");
                        if (player.getHp() >= player.getHpMin()) {
                            System.out.println("Vos points de vie augmentent de " + (player.getHpMax() - player.getHp()) + "!");
                            System.out.println("----------------------------------------------------");
                            player.setHp(player.getHpMax());

                        } else {
                            System.out.println("Vos points de vie augmentent de " + ((BigHealthPotion) bigPotion1).getHealth() + "!");
                            System.out.println("----------------------------------------------------");
                            player.setHp(player.getHp() + ((BigHealthPotion) bigPotion1).getHealth());
                        }
                        player.getInventory().inventory[4] = null;
                        System.out.println("Vous avez désormais " + player.getHp() + " points de vie.");
                        System.out.println("----------------------------------------------------");
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de points de vie!");
                        System.out.println(" ---------------------------------------------------");
                    }
                }

                break;


            case 5:
                Object bigPotion2 = player.getInventory().inventory[5];
                if (bigPotion2 instanceof BigHealthPotion) {
                    if (player.getHp() < player.getHpMax()) {
                        System.out.println("Vous buvez la potion... Glouglou... hips!");
                        if (player.getHp() >= player.getHpMin()) {
                            System.out.println("Vos points de vie augmentent de " + (player.getHpMax() - player.getHp()) + "!");
                            System.out.println("----------------------------------------------------");
                            player.setHp(player.getHpMax());
                        } else {
                            System.out.println("Vos points de vie augmentent de " + ((BigHealthPotion) bigPotion2).getHealth() + "!");
                            System.out.println("----------------------------------------------------");
                            player.setHp(player.getHp() + ((BigHealthPotion) bigPotion2).getHealth());
                        }
                        player.getInventory().inventory[5] = null;
                        System.out.println("Vous avez désormais " + player.getHp() + " points de vie.");
                        System.out.println("----------------------------------------------------");
                    } else {
                        System.out.println("... Mais vous avez déjà atteint votre maximum de points de vie!");
                        System.out.println(" ---------------------------------------------------");
                    }
                }
                break;
            case 9:
                break;
            default:
                displayInventory(player);
        }
    }

    public void playerAttack(Character player, Enemy enemy) {
        while (enemy.getHp() > 0 && player.getHp() > 0) {
            enemy.setDead(false);
            System.out.println("_______________________________________________________");
            System.out.println("Vous attaquez le " + enemy.getName() + " et lui infligez " + player.getAttack() + " points de dégats");
            enemy.setHp(enemy.getHp() - player.getAttack());
            if (enemy.getHp() > 0) {
                System.out.println("L'ennemi a encore " + enemy.getHp() + " points de vie.");
            } else {
                enemy.setDead(true);
                System.out.println("Vous avez vaincu le " + enemy.getName() + "!");
            }
            System.out.println("----------------------------------------------------");
        }
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getAttackMax() {
        return attackMax;
    }

    public int getHpMin() {
        return hpMin;
    }

    public int getAttackMin() {
        return attackMin;
    }

    public String getName() {
        return name;
    }

    public String descriptionWarrior() {
        return "Votre personnage s'appelle " + this.name + ", c'est un(e) brave et fier(e) guerrier(e), il/elle a " + this.hp + " points de vie et "
                + this.attack + " d'attaque. ";
    }

    public String descriptionWizard() {
        return "Votre personnage s'appelle " + this.name + ", c'est un(e) redoutable magicien(ne), il/elle a " + this.hp + " points de vie et "
                + this.attack + " d'attaque. ";
    }

    /**
     * Method that displays the stats of the player.
     * displays player's name, hp, attack and defense
     * It takes one parameter :
     *
     * @param player : the current player
     */
    public void showStats(Character player) {
        if (player instanceof Warrior) {
            if (((Warrior) player).getWeapon() == null && ((Warrior) player).getProtection() == null) {
                System.out.println(getName() + " ==>  PV : " + getHp() + " || ATK : " + getAttack() + " (Pas d'arme)" + " || DEF : 0 (Pas de protection)");
            } else if (((Warrior) player).getWeapon() == null || ((Warrior) player).getProtection() == null) {
                if (((Warrior) player).getWeapon() == null) {
                    System.out.println(getName() + " ==>  PV : " + getHp() + "|| ATK : " + getAttack() + " (Pas d'arme)" + " || DEF : " + ((Warrior) player).getProtection().getDefense() + " (" + ((Warrior) player).getProtection().getName() + ")");
                } else if (((Warrior) player).getProtection() == null) {
                    System.out.println(getName() + " ==>  PV : " + getHp() + "|| ATK : " + getAttack() + " (" + ((Warrior) player).getWeapon().getName() + ")" + " || DEF : 0 (Pas de protection)");
                }
            }
        } else if (player instanceof Wizard) {
            if (((Wizard) player).getWeapon() == null && ((Wizard) player).getProtection() == null) {
                System.out.println(getName() + " ==>  PV : " + getHp() + " || ATK : " + getAttack() + " (Pas d'arme)" + " || DEF : 0 (Pas de protection)");
            } else if (((Wizard) player).getWeapon() == null || ((Wizard) player).getProtection() == null) {
                if (((Wizard) player).getWeapon() == null) {
                    System.out.println(getName() + " ==>  PV : " + getHp() + "|| ATK : " + getAttack() + " (Pas d'arme)" + " || DEF : " + ((Wizard) player).getProtection().getDefense() + " (" + ((Wizard) player).getProtection().getName() + ")");
                } else if (((Wizard) player).getProtection() == null) {
                    System.out.println(getName() + " ==>  PV : " + getHp() + "|| ATK : " + getAttack() + " (" + ((Wizard) player).getWeapon().getName() + ")" + " || DEF : 0 (Pas de protection)");
                }
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                '}';
    }
}
