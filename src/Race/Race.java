package Race;

import Inventory.Player;

/**
 * Defines the characteristics and abilities of the player's given race.
 */
public interface Race {
    String getRaceName();

    void racesDescriptions(Player player);
}
