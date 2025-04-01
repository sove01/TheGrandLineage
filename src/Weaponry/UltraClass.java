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
                        ultraSkills.add(new Skill("Elegant slash", "Cuts the opponent vital points ", "Orderly", 40));
                        ultraSkills.add(new Skill("Needle's eye", "Lunge forward slashing enemy in it's path.", "Orderly", 35));
                        break;
                    case "sword":
//                        ultraSkills.add(new Skill("White flame charged blow"));
                        ultraSkills.add(new Skill("white flame charged blow", "Erupts the ground with white flames toward the enemy", "Orderly", 60));
                        ultraSkills.add(new Skill("Disarm", "Disarms the enemy", "Orderly", 10));
                        break;
                    case "spear":
//                        ultraSkills.add(new Skill("Thunder crash"));
                        ultraSkills.add(new Skill("Dragon crusher", "A roaring strike representing a dragons head", "Orderly", 75));
                        ultraSkills.add(new Skill("Wing Soar", "Allows one to jump high in the sky", "Orderly", 0));
                        break;
                    case "fist":
//                        ultraSkills.add(new Skill("Lighting elbow"));
                        ultraSkills.add(new Skill("Lightning elbow", "Dashs forward in lightning speed damaging the enemy in the way", "Orderly", 55));
                        ultraSkills.add(new Skill("Lightning aura", "Negates one's fall damage for a short time ", "Orderly", 0));
                        break;
                }
            } else if ("Chaotic".equalsIgnoreCase(alignment)) {
                switch (weapon.toLowerCase()) {
                    case "dagger":
                        ultraSkills.add(new Skill("Shadow fan", "Throws forward 5 knives, if hit, teleports onto hit enemy", "Chaotic", 25));
                        ultraSkills.add(new Skill("Ethereal strike", "Strike the opponent in the chest", "Chaotic", 65));
                        break;
                    case "sword":
                        ultraSkills.add(new Skill("Dark flame charged blow", "Erupts the ground with dark flames toward the enemy", "Chaotic", 60));
                        ultraSkills.add(new Skill("Disarm", "Disarms the enemy", "Chaotic", 10));
                        break;
                    case "spear":
//                        ultraSkills.add(new Skill("Leviathan purge"));
//                        ultraSkills.add(new Skill("Deepwoken sacrifice"));
                        ultraSkills.add(new Skill("Dark flame charged blow", "z", "Chaotic", 40));
                        ultraSkills.add(new Skill("Dark flame charged blow", "z", "Chaotic", 40));
                        break;
                    case "fist":
//                        ultraSkills.add(new Skill("Demon flip"));
//                        ultraSkills.add(new Skill("Demon step"));
//                        ultraSkills.add(new Skill("Rising dragon"));
                        ultraSkills.add(new Skill("Dark flame charged blow", "z", "Chaotic", 40));
                        ultraSkills.add(new Skill("Dark flame charged blow", "z", "Chaotic", 40));
                        break;
                }
            }
        }
        public List<Skill> getUltraSkills() {
        return ultraSkills;
        }
    }
