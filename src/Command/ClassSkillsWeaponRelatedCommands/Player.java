package Command.ClassSkillsWeaponRelatedCommands;

import Command.Command;

import java.util.List;

public class Player {
    private String name;
    private Weapon equippedWeapon;
    private List<Skill> learnedSkills;
    private int experience;

    public void equipWeapon(Weapon weapon) {}
    public void learnSkill(Skill skill) {}
    public void executeCommand(Command command) {}
    public void gainExperience(int xp) {}
}
