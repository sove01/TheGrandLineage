package Weaponry;

import java.util.ArrayList;
import java.util.List;

public class SuperClass extends BaseClass {
    private List<Skill> superSkills;

    public SuperClass(String weapon, String alignment) {
        super(weapon);
        superSkills = new ArrayList<Skill>();


        if ("Orderly".equalsIgnoreCase(alignment)) {
            switch (weapon.toLowerCase()) {
                case "dagger":
                    superSkills.add(new Skill("Advanced Agility", "A surge of speed boost.", "Orderly", 0));
                    break;
                case "sword":
                    superSkills.add(new Skill("Action Surge", "Slashes the opponent with a flurry of attacks. ", "Orderly", 40));
                    break;
                case "spear":
                    superSkills.add(new Skill());
                    break;
                case "fist":
                    superSkills.add(new Skill());
                    break;
            }
        } else if ("Chaotic".equalsIgnoreCase(alignment)) {
            switch (weapon.toLowerCase()) {
                case "dagger":
                    superSkills.add(new Skill("AdvancedAgility", "A surge of speed boost.", "Orderly", 0));
                    break;
                case "sword":
                    superSkills.add(new Skill());
                    break;
                case "spear":
                    superSkills.add(new Skill());
                    break;
                case "fist":
                    superSkills.add(new Skill());
                    break;
            }
        }
    }

    public List<Skill> getSuperSkills() {
        return superSkills;
    }

}
