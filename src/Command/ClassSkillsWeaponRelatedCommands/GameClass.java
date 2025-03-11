package Command.ClassSkillsWeaponRelatedCommands;

import java.util.List;

public class GameClass {
    private String name;
    private String progressionType;
    private int tier; // 1 = Base, 2 = Super, 3 = Ultra
    private List<Skill> availableSkills;

    public void advanceTier() {}
    public List<Skill> getSkills() { return availableSkills; }
}
