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
                    superSkills.add(new Skill("AdvancedAgility", "A surge of speed boost.", "Orderly", 0));
                    break;
                case "sword":
                    superSkills.add();
                    break;
                case "spear":
                    superSkills.add();
                    break;
                case "fist":
                    superSkills.add();
                    break;
            }
        } else if ("Chaotic".equalsIgnoreCase(alignment)) {
            switch (weapon.toLowerCase()) {
                case "dagger":
                    superSkills.add(new Skill("AdvancedAgility", "A surge of speed boost.", "Orderly", 0));
                    break;
                case "sword":
                    superSkills.add();
                    break;
                case "spear":
                    superSkills.add();
                    break;
                case "fist":
                    superSkills.add();
                    break;
            }
        }
    }

    public List<Skill> getSuperSkills() {
        return superSkills;
    }

}
