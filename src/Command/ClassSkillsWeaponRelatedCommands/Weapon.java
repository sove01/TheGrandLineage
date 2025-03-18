package Command.ClassSkillsWeaponRelatedCommands;

import java.util.List;

public interface Weapon {
    String getWeaponName();
    String attack();
    String defend();
    List<Skill> getOrderlySkills();
    List<Skill> getChaoticSkills();
}
