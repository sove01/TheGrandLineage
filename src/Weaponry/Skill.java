package Weaponry;

/**
 * Represents a combat skill with name, effect, type, and power level.
 */
public class Skill {
    private final String skillName;
    private final String skillEffect;
    private final String skillNature; // "Physical", "Magical", etc.
    private final int power; // Damage/healing amount

    /**
     * Creates a new skill.
     *
     * @param skillName   Name
     * @param skillEffect Description of effect
     * @param skillNature Damage/healing type
     * @param power       Strength
     */
    public Skill(String skillName, String skillEffect, String skillNature, int power) {
        this.skillName = skillName;
        this.skillEffect = skillEffect;
        this.skillNature = skillNature;
        this.power = power;
    }


    public String getSkillName() {
        return skillName;
    }

    public String getSkillEffect() {
        return skillEffect;
    }

    public String getSkillNature() {
        return skillNature;
    }

    public int getPower() {
        return power;
    }

    /**
     * Activates the skill.
     *
     * @return Skill activation message
     */
    public String use() {
        return skillName + " activated! " + skillEffect;
    }
}