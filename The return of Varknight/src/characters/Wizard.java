package characters;

import equipments.Protections;
import equipments.Weapons;

/**
 * Class that represents one type of Character the player can choose to play.
 * Currently it has 2 attributes :
 * - 'hasThunderStrike' : boolean that lets you verify if player already has a weapon of type ThunderStrike equipped or not.
 * - 'hasFireball' : boolean that lets you verify if player already has a weapon of type FireBall equipped or not.
 *
 * @see equipments.Thunderstrike
 * @see equipments.Fireball
 */
public class Wizard extends Character {

    private boolean hasThunderstrike;
    private boolean hasFireBall;
    private Weapons weapon;
    private Protections protection;

    /**
     * Wizard Constructor.
     * It has pre a set of attributes (declared previously on its parent's class Character)
     * Lets you instantiate a Wizard type character requiring only one parameter :
     *
     * @param name : player's name.
     * @see Character
     */
    public Wizard(String name) {
        super(name, 3, 3, 6, 8, 8, 15, new Inventory());
        this.hasThunderstrike = false;
        this.hasFireBall = false;
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

    public void setHasThunderstrike(boolean hasThunderstrike) {
        this.hasThunderstrike = hasThunderstrike;
    }

    public void setHasFireBall(boolean hasFireBall) {
        this.hasFireBall = hasFireBall;
    }

    public boolean hasThunderstrike() {
        return hasThunderstrike;
    }

    public boolean hasFireBall() {
        return hasFireBall;
    }

    public String toString() {
        return super.toString();
    }
}
