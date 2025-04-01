package Weaponry;

/**
 * Represents a character's basic combat class and weapon.
 */
public class BaseClass {
    private final String weapon; // weapon type

    /**
     * Creates a base class with specified weapon.
     *
     * @param weapon The class's weapon specialization
     */
    public BaseClass(String weapon) {
        this.weapon = weapon;
    }

    /**
     * @return The class's weapon type
     */
    public String getWeapon() {
        return weapon;
    }
}