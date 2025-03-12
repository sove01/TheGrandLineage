package Command.ClassSkillsWeaponRelatedCommands;

import Command.Command;

import java.util.List;

public class Player {
    public Player(String name, Weapon equippedWeapon, List<Skill> learnedSkills, int experience) {
        this.name = name;
        this.equippedWeapon = equippedWeapon;
        this.learnedSkills = learnedSkills;
        this.experience = experience;
    }

    private String name;
    private Weapon equippedWeapon;
    private List<Skill> learnedSkills;
    private int experience;

    public void equipWeapon(Weapon weapon) {
    }

    public void learnSkill(Skill skill) {
    }

    public void executeCommand(Command command) {
    }

    public void gainExperience(int xp) {
    }
}
