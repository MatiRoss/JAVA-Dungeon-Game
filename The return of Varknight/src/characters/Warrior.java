package characters;

import equipments.Protections;
import equipments.Weapons;

/**
 * Class that represents one type of Character the player can choose to play.
 * Currently it has 3 attributes :
 * - 'hasClub' : boolean that lets you verify if player already has a club equipped or not.
 * - 'hasSword' : boolean that lets you verify if player already has a sword equipped or not.
 * - 'hasBow' : boolean that lets you verify if player already has a bow equipped or not.
 *
 * @see equipments.Club
 * @see equipments.Sword
 * @see equipments.Bow
 */

public class Warrior extends Character {

    private boolean hasClub;
    private boolean hasSword;
    private boolean hasBow;
    private Weapons weapon;
    private Protections protection;

    public Warrior() {
    }

    /**
     * Warrior Constructor.
     * It has pre a set of attributes (declared previously in its parent's class Character)
     * Lets you instantiate a Warrior type character requiring only one parameter :
     *
     * @param name : player's name.
     * @see Character
     */
    public Warrior(String name) {
        super(name, 5, 5, 10, 5, 5, 10, new Inventory());
        this.hasClub = false;
        this.hasSword = false;
        this.hasBow = false;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public void setProtection(Protections protection) {
        this.protection = protection;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public Protections getProtection() {
        return protection;
    }

    public void setHasBow(boolean hasBow) {
        this.hasBow = hasBow;
    }

    public void setHasClub(boolean hasClub) {
        this.hasClub = hasClub;
    }

    public void setHasSword(boolean hasSword) {
        this.hasSword = hasSword;
    }

    public boolean hasBow() {
        return hasBow;
    }

    public boolean hasClub() {
        return hasClub;
    }

    public boolean hasSword() {
        return hasSword;
    }

    public String toString() {
        return super.toString();
    }
}
