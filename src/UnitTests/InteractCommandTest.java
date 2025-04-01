package UnitTests;

import Command.InteractCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import NPC.GameObject;
import Inventory.Player;

class InteractCommandTest {

    class TestNPC extends GameObject {
        public TestNPC(String name) {
            super(name, "Test dialogue");
        }

        @Override
        public void interact(Player player) {
            System.out.println(getDialogue());
        }
    }

    @Test
    void execute_returnsCorrectInteractionMessage() {
        Player player = new Player("TestPlayer");
        GameObject npc = new TestNPC("Merchant");
        InteractCommand command = new InteractCommand(player, npc);

        String result = command.execute();

        assertEquals("Interacted with Merchant.", result);
    }

    @Test
    void undo_returnsEmptyString() {
        InteractCommand command = new InteractCommand(
                new Player("Test"),
                new TestNPC("Guard")
        );
        assertEquals("", command.undo());
    }

    @Test
    void exit_alwaysReturnsFalse() {
        InteractCommand command = new InteractCommand(
                new Player("Test"),
                new TestNPC("Innkeeper")
        );
        assertFalse(command.exit());
    }
}
