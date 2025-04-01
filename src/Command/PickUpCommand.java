package Command;

import Inventory.Item;
import Inventory.Player;
import World.Location;

/**
 * Handles picking up items from locations and adding them to player inventory.
 */
public class PickUpCommand implements Command {
    private Player player;
    private Item item;
    private Location location;


    public PickUpCommand(Player player, Item item) {
        this.player = player;
        this.item = item;
    }

    @Override
    public String execute() {
        player.pickup(item);
        return "Picked up " + item.getName() + ".";
    }

    @Override
    public String undo() {
        location.removeItems(item);
        player.getInventory().removeItem(item);
        return "Undid picking up " + item.getName() + ".";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
