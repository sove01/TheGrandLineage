package UnitTests;

import NPC.UltraClassNPC;
import Weaponry.BaseClass;
import Weaponry.Skill;
import Weaponry.SuperClass;
import Weaponry.UltraClass;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SkillTest {
    void skillCreationAndUsage() {
        Skill fireball = new Skill("SkillTest", "SkillTest", "Chaotic", 30);

        assertEquals("SkillTest", fireball.getSkillName());
        assertEquals("SkillTest", fireball.getSkillEffect());
        assertEquals("Chaotic", fireball.getSkillNature());
        assertEquals(30, fireball.getPower());
        assertEquals("Using skill: SkillTest", fireball.use());
    }

    @Test
    void superClassSkillCreation() {
        SuperClass orderlySwordsman = new SuperClass("sword", "Orderly");
        List<Skill> skills = orderlySwordsman.getSuperSkills();

        assertEquals(2, skills.size());
        assertEquals("Action Surge", skills.get(0).getSkillName());
        assertEquals(40, skills.get(0).getPower());
    }

    @Test
    void ultraClassSkillInheritance() {
        UltraClass chaoticDagger = new UltraClass("dagger", "Chaotic");
        List<Skill> ultraSkills = chaoticDagger.getUltraSkills();

        assertEquals(2, ultraSkills.size());
        assertEquals("Shadow fan", ultraSkills.get(0).getSkillName());
        assertTrue(chaoticDagger.getSuperSkills().size() > 0);
    }

    @Test
    void baseClassWeaponAssignment() {
        BaseClass fist = new BaseClass("fist");
        assertEquals("fist", fist.getWeapon());
    }
}
