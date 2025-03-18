package Command;

import Inventory.Item;
import Inventory.Player;

public class PickUpCommand implements Command {
    private Player player;
    private Item item;

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
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
