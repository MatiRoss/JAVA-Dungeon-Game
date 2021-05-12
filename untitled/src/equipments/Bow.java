package equipments;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import game.Cell;

/**
 * Class that represents a bow.
 * Inherits from the class Weapons
 *
 * @see Weapons
 */
public class Bow extends Weapons {

    /**
     * Bow Constructor.
     * Sets the attributes of the item
     */
    public Bow() {
        super("Arc", 4);
    }

    /**
     * Method inherited from parent Cell.
     * Handles the interaction between the item and the player.
     * It takes 2 parameters :
     *
     * @param player refers to the current player
     * @param cell   refers to the cell the player is currenty on
     */
    @Override
    public void interaction(Character player, Cell cell) {
        if (player instanceof Wizard) {
            System.out.println("... Mais vous êtes un magicien, les armes c'est pour les barbares!");
            System.out.println(" ---------------------------------------------------");
        } else {
            if (player.getAttack() < player.getAttackMax()) {
                if (!((Warrior) player).hasBow()) {
                    System.out.println("Vous vous équipez de l'arme.");
                    player.setAttack(player.getAttackMin() + getPower());
                    System.out.println("Vos dégats augmentent de " + getPower() + " et passent à " + player.getAttack() + ".");
                    System.out.println(" ---------------------------------------------------");
                    ((Warrior) player).setHasBow(true);
                } else {
                    System.out.println("... Mais vous possédez déjà une " + getName() + "!");
                    System.out.println(" ---------------------------------------------------");
                }
            } else {
                System.out.println("... Mais vous avez déjà atteint votre maximum de puissance d'attaque!");
                System.out.println(" ---------------------------------------------------");
            }
        }
    }
}

