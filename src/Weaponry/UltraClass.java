package Weaponry;

import java.util.ArrayList;
import java.util.List;

public class UltraClass extends  SuperClass {
    private List<Skill> ultraSkills;

    public UltraClass(String weapon, String alignment) {
        super(weapon, alignment);
        this.ultraSkills = new ArrayList<Skill>();


            if ("Orderly".equalsIgnoreCase(alignment)) {
                switch (weapon.toLowerCase()) {
                    case "dagger":
                        ultraSkills.add(new Skill("AdvancedAgility", "A surge of speed boost.", "Orderly", 0));
                        break;
                    case "sword":
                        ultraSkills.add();
                        break;
                    case "spear":
                        ultraSkills.add();
                        break;
                    case "fist":
                        ultraSkills.add();
                        break;
                }
            } else if ("Chaotic".equalsIgnoreCase(alignment)) {
                switch (weapon.toLowerCase()) {
                    case "dagger":
                        ultraSkills.add(new Skill("AdvancedAgility", "A surge of speed boost.", "Orderly", 0));
                        break;
                    case "sword":
                        ultraSkills.add();
                        break;
                    case "spear":
                        ultraSkills.add();
                        break;
                    case "fist":
                        ultraSkills.add();
                        break;
                }
            }
        }
        public List<Skill> getUltraSkills() {
        return ultraSkills;
        }
    }
