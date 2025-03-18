package Command.ClassSkillsWeaponRelatedCommands;

import Command.Command;
import Inventory.Player;

public class UseSkillCommand implements Command {
    private Player player;
    private Skill skill;

    public UseSkillCommand(Player player, Skill skill) {}

//    @Override
//    public String execute(Player player, Skill skill) {
//        return "Using skill : " + skill.getName() + player.getClass();
//    }


    @Override
    public String execute() {
        return "Using Skill : " + skill.getName() + player.getClass();
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
