package Weaponry;

public class Skill {
    private String skillName;
    private String skillEffect;
    private String skillNature;
    private int power;

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

    public String use() {
        return "Using skill: " + skillName;
    }
}
