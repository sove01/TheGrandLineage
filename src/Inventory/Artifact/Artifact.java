package Inventory.Artifact;

import Inventory.Item;
import Inventory.Player;

/**
 * Special items with magical effects that can be used by players.
 * Extends basic Item functionality with unique effects.
 */
public class Artifact extends Item {
    private String Effect;

    /**
     * Creates a new artifact with special properties.
     *
     * @param effect      The effect description
     * @param name        The artifact's name
     * @param description Description
     * @param value       Value
     */

    public Artifact(String effect, String name, String description, int value) {
        super(name, description, true, value);
        Effect = effect;
    }

    /**
     * Activates the artifact's effect on the player.
     *
     * @param player The player using the artifact
     * @return Formatted string describing the usage and effect
     */

    @Override
    public String use(Player player) {
        return "Using artifact : " + getName() +
                "\n" + "Effect : " + Effect;
    }
}
