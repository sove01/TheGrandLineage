package Command;

import Inventory.Item;
import Inventory.Player;
import World.Location;

/**
 * Handles picking up items from locations and adding them to player inventory.
 * Picks up items one by one.
 */
public class PickUpCommand implements Command {
    private Player player;
    private Location location;


    public PickUpCommand(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    @Override
    public String execute() {
        // Check if there are items in the location to pick up
        if (location != null && !location.getItems().isEmpty()) {
            // Get the first item from the location
            Item item = location.getItems().get(0);  // Always pick the first item
            player.pickup(item);  // Add the item to the player's inventory
            location.getItems().remove(0);  // Remove item from the location
            return "Picked up " + item.getName() + ".";
        } else {
            return "No items to pick up at this location.";
        }
    }

    @Override
    public String undo() {
        // Get the last item
        if (!player.getInventory().getItems().isEmpty()) {
            Item item = player.getInventory().getItems().get(player.getInventory().getItems().size() - 1);
            player.getInventory().removeItem(item);
            return "Undid picking up " + item.getName() + ".";
        }
        return "No items to undo.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
