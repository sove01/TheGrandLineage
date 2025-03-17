package Command;

import Command.Inventory.Player;

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
