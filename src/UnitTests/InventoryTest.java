package UnitTests;

import Inventory.Inventory;
import Inventory.Item;
import Inventory.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;
    private Item sword;
    private Item potion;


    class TestItem extends Item {
        public TestItem(String name, int value) {
            super(name, "Test " + name, false, value);
        }

        @Override
        public String use(Player player) {
            return "Using " + name;
        }
    }

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        sword = new TestItem("Sword", 50);
        potion = new TestItem("Health Potion", 20);
    }

    @Test
    void shouldAddItemsToInventory() {
        inventory.addItem(sword);
        assertEquals(1, inventory.getItems().size());
        assertTrue(inventory.getItems().contains(sword));
    }

    @Test
    void shouldRemoveItemsFromInventory() {
        inventory.addItem(potion);
        inventory.removeItem(potion);
        assertTrue(inventory.getItems().isEmpty());
    }

    @Test
    void shouldMaintainList() {
        inventory.addItem(sword);
        inventory.addItem(potion);
        assertEquals(2, inventory.getItems().size());
        assertEquals("Sword", inventory.getItems().get(0).getName());
    }
}