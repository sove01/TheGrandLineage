package Command.Inventory;

import Command.ClassSkillsWeaponRelatedCommands.Skill;
import Command.ClassSkillsWeaponRelatedCommands.Weapon;
import Command.Command;
import Command.Inventory.Artifact.Artifact;

import java.util.List;

public class Player {
    private Inventory inventory;
    private String name;
    private Weapon equippedWeapon;
    private List<Skill> learnedSkills;
    private int experience;

    public Player(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        Command itemUsageCommand = new ItemUsage(this, item);
        itemUsageCommand.execute();
    }

    public void displayInventory() {
        inventory.displayInventory();
    }


    public void pickup(Item item) {
        inventory.addItem(item);
        System.out.println("Picked up " + item.getName());
    }

//    public void useItem(Item item) {
//        Command itemUsageCommand = new ItemUsage(this, item);
//        itemUsageCommand.execute();
//    }

    public String applyArtifactEffect(Artifact artifact) {
        return "Applying artifact effect:" + artifact.getName();
    }

    public void equipWeapon(Weapon weapon) {
    }

    public void learnSkill(Skill skill) {
    }

    public void executeCommand(Command command) {
    }

    public void gainExperience(int xp) {
    }
}


