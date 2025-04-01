package Command;

import Inventory.Player;

/**
 * Displays the player's current inventory when executed.
 */
public class InventoryCommand implements Command {
    private Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        player.displayInventory();
        return "Displayed Inventory.";
    }

    @Override
    public String undo() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
