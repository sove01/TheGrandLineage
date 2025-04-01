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
                    superSkills.add(new Skill("Advanced Stealth", "Cover one's presence in a transparent mist.", "Orderly", 0));
                    break;
                case "sword":
                    superSkills.add(new Skill("Action Surge", "Slashes the opponent with a flurry of attacks. ", "Orderly", 40));
                    superSkills.add(new Skill("Pomel Strike", "Strikes the opponent with the sword's hilt ", "Orderly", 20));
                    break;
                case "spear":
                    superSkills.add(new Skill("Serpent strike", "A snake like poisonous attack", "Orderly", 50));
                    superSkills.add(new Skill("Triple strike", "Thrusts the spear forward 3 times.", "Orderly", 50));
                    break;
                case "fist":
                    superSkills.add(new Skill("Monatic stance", "Changes one's stance with flaming fists", "Orderly", 0));
                    superSkills.add(new Skill("Dragon's fist", "Your attacks now apply fire", "Orderly", 40));
                    break;
            }
        } else if ("Chaotic".equalsIgnoreCase(alignment)) {
            switch (weapon.toLowerCase()) {
                case "dagger":
                    superSkills.add(new Skill("Lethality", "A chain of mutilating dagger slashes", "Chaotic", 50));
                    superSkills.add(new Skill("Faceless one", "Changes one's name to Faceless one", "Chaotic", 50));
                    break;
                case "sword":
                    superSkills.add(new Skill("Knight lords stance", "Changes one's stance", "Chaotic", 45));
                    superSkills.add(new Skill("Dark flames charge", "Cover one's sword in dark flames", "Chaotic", 0));
                    break;
                case "spear":
                    superSkills.add(new Skill("Impale", "Thrust the spear towards enemy", "Chaotic", 40));
                    superSkills.add(new Skill("Light piercer", "Sends out 3 light projectiles toward enemy", "Chaotic", 15));
                    break;
                case "fist":
                    superSkills.add(new Skill("Leg breaker", "A powerful kick", "Chaotic", 30));
                    superSkills.add(new Skill("Spinning kick", "A spinning kick", "Chaotic", 25));
                    break;
            }
        }
    }

    public List<Skill> getSuperSkills() {
        return superSkills;
    }

}
