package Inventory;

import Command.Command;

public class ItemUsage implements Command {
    private Player player;
    private Item item;

    public ItemUsage(Player player, Item item) {
        this.player = player;
        this.item = item;
    }

    @Override
    public String execute() {
        return "Used item : " + item.use(player);
    }

    @Override
    public String undo() {
        return "Undoing item usage: " + item.getName();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
