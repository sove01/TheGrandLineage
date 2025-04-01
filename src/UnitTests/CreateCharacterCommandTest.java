package UnitTests;

import Command.CreateCharacterCommand;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class CreateCharacterCommandTest {
    @Test
    void testCreatesPlayer() {
        // Setup
        Scanner scanner = new Scanner("TestPlayer");
        CreateCharacterCommand command = new CreateCharacterCommand(scanner);

        String result = command.execute();

        assertTrue(result.startsWith("Your character name is TestPlayer"));
        assertNotNull(command.getPlayer());
    }

    @Test
    void testUndoReturnsEmpty() {
        CreateCharacterCommand command = new CreateCharacterCommand(new Scanner(""));
        assertEquals("", command.undo());
    }

    @Test
    void testExitReturnsFalse() {
        CreateCharacterCommand command = new CreateCharacterCommand(new Scanner(""));
        assertFalse(command.exit());
    }
}
