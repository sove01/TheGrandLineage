package Command.Inventory;

import Command.ClassSkillsWeaponRelatedCommands.Player;
import Command.Command;

public class ItemUsage implements Command {
    private Player player;
    private Item item;

    public ItemUsage(Player player, Item item) {
        this.player = player;
        this.item = item;
    }

    @Override
    public void execute() {
        item.use(player);
    }

    @Override
    public void undo() {
        System.out.println("Undoing item usage: " + item.getName());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
