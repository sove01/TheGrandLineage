package UnitTests;
import static org.junit.jupiter.api.Assertions.*;

import Inventory.Item;
import NPC.Doctor;
import NPC.Merchant;
import NPC.QuestGiver;
import org.junit.jupiter.api.Test;
import Inventory.Player;

public class NPCTest {
    @Test
    void doctorHealsWhenPaid() {
        Player player = new Player("Test");
        player.plusSilver(20); // Give player some mula
        Doctor doctor = new Doctor("Doc", "I can heal you");

        doctor.interact(player);

        assertEquals(100, player.getHealth());
        assertEquals(10, player.getSilver()); // 20 - 10
    }

    @Test
    void merchantBuysTrinkets() {
        Player player = new Player("Test");
        Merchant merchant = new Merchant("Shop", "Welcome");
        TestItem trinket = new TestItem("Ring", 5);

        // Start with empty inventory
        assertTrue(player.getInventory().getItems().isEmpty());

        // Add 1 item
        player.pickUpItem(trinket);
        assertEquals(1, player.getInventory().getItems().size());

        // Sell the item
        merchant.interact(player);

        // result
        assertEquals(10, player.getSilver());
        assertTrue(player.getInventory().getItems().isEmpty());
    }

    @Test
    void questGiverGivesXP() {
        Player player = new Player("Test");
        player.setAlignment("Orderly");
        QuestGiver questGiver = new QuestGiver("Quest", "Help needed");

        questGiver.interact(player);

        assertEquals(50, player.getExperience());
        assertEquals(10, player.getOrderlyPoints());
    }

    // testItem
    static class TestItem extends Item {
        public TestItem(String name, int value) {
            super(name, "Test", false, value);
        }
        public String use(Player p) { return ""; }
    }
}
