package Command.ClassSkillsWeaponRelatedCommands;

import Command.Command;
import Command.Inventory.Player;

public class UseSkillCommand implements Command {
    private Player player;
    private Skill skill;

    public UseSkillCommand(Player player, Skill skill) {}

    @Override
    public String execute() {
        return "";
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
