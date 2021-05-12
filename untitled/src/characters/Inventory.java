package characters;

import equipments.BigHealthPotion;
import equipments.HealthPotion;
import equipments.Protections;
import equipments.Weapons;
import game.Cell;

import java.util.Arrays;

/**
* Class that represents the player's inventory.
        * It has 5 attributes :
        * - 'inventory' : the actual player's inventory (array of objects)
        * - 'weapons' : object of type Weapons that can be stored in inventory
        * - 'protections' : object of type Protections that can be stored in inventory
        * - 'healthPotion' : object representing a potion that can be stored in inventory
        * - 'bigHealthPotion' : object representing a bigger potion that can be stored in inventory
        *
        * @see Weapons
        * @see Protections
        * @see HealthPotion
        * @see BigHealthPotion
        */
public class Inventory {
    Object[] inventory;

    /**
     * Inventory Constructor.
     * Instantiation of the inventory with length set to 6.
     * 1st slot can only store Weapons, 2nd slot can only store Protections, etc...
     */
    public Inventory() {
        inventory = new Object[6];

        inventory[0] = getWeapons();
        inventory[1] = getProtections();
        inventory[2] = getHealthPotion1();
        inventory[3] = getHealthPotion2();
        inventory[4] = getBigHealthPotion1();
        inventory[5] = getBigHealthPotion2();

    }

    /**
     * Method that dispatches items in inventory in specific slots based on item type
     * It takes 1 parameter :
     * @param item : the item to be added to the inventory
     */
    public void setInventory(Object item) {
        if (item instanceof Weapons) {
            if (this.inventory[0] == null) {
                System.out.println("Vous rangez l'objet dans votre sac.");
                this.inventory[0] = item;
            } else {
                System.out.println("Vous ne pouvez avoir qu'une seule arme dans l'inventaire.");
            }
        } else if (item instanceof Protections) {
            if (this.inventory[1] == null) {
                System.out.println("Vous rangez l'objet dans votre sac.");
                this.inventory[1] = item;
            } else {
                System.out.println("Vous ne pouvez avoir qu'un seul bouclier dans l'inventaire.");
            }
        } else if (item instanceof HealthPotion) {
            if (this.inventory[2] == null || this.inventory[3] == null) {
                if (this.inventory[2] == null) {
                    System.out.println("Vous rangez la potion dans votre sac.");
                    this.inventory[2] = item;
                } else {
                    System.out.println("Vous rangez la potion dans votre sac.");
                    this.inventory[3] = item;
                }
            } else {
                System.out.println("Vous ne pouvez pas porter plus de " + ((HealthPotion) item).getName() + "!");
            }
        } else if (item instanceof BigHealthPotion) {
            if (this.inventory[4] == null || this.inventory[5] == null) {
                if (this.inventory[4] == null) {
                    System.out.println("Vous rangez la potion dans votre sac.");
                    this.inventory[4] = item;
                } else {
                    System.out.println("Vous rangez la potion dans votre sac.");
                    this.inventory[5] = item;
                }
            } else {
                System.out.println("Vous ne pouvez pas porter plus de " + ((BigHealthPotion) item).getName() + "!");
            }
        }
    }

    public Weapons getWeapons() {
        return (Weapons) this.inventory[0];
    }

    public Protections getProtections() {
        return (Protections) this.inventory[1];
    }

    public HealthPotion getHealthPotion1() {
        return (HealthPotion) this.inventory[2];
    }

    public HealthPotion getHealthPotion2() {
        return (HealthPotion) this.inventory[3];
    }

    public BigHealthPotion getBigHealthPotion1() {
        return (BigHealthPotion) this.inventory[4];
    }

    public BigHealthPotion getBigHealthPotion2() {
        return (BigHealthPotion) this.inventory[5];
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + Arrays.toString(inventory) +
                ", weapons=" + getWeapons() +
                ", protections=" + getProtections() +
                ", healthPotion=" + getHealthPotion1() +
                ", bigHealthPotion=" + getBigHealthPotion1() +
                '}';
    }
}
