package Weaponry;

import Command.ClassSkillsWeaponRelatedCommands.Skill;
import Command.ClassSkillsWeaponRelatedCommands.Weapon;

import java.util.List;

public class Fist implements Weapon {

    @Override
    public String getWeaponName() {
        return "";
    }

    @Override
    public String attack() {
        return "";
    }

    @Override
    public String defend() {
        return "";
    }

    @Override
    public List<Skill> getOrderlySkills() {
        return List.of();
    }

    @Override
    public List<Skill> getChaoticSkills() {
        return List.of();
    }
}
