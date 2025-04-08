package UnitTests;

import Command.MoveCommand;
import Inventory.Player;
import World.Location;
import World.Region;
import World.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {
    private WorldMap worldMap;
    private MoveCommand command;
    private Player player;

    @BeforeEach
    void setUpMap() {
        // Creates a world map
        class TestWorldMap extends WorldMap {
            private int currentLocation = 1;

            public TestWorldMap() {
                // Creates test regions and locations
                Region forest = new Region("Forest");
                Location loc1 = new Location("Church", 1, new int[]{2, -1, -1, -1}, forest);
                Location loc2 = new Location("Royal Woods", 2, new int[]{-1, 1, -1, -1}, forest);

                // Adds to the map
                forest.addLocation(loc1);
                forest.addLocation(loc2);
                getRegions().put("Forest", forest);
                getWorld().put(1, loc1);
                getWorld().put(2, loc2);

            }


            @Override
            public boolean loadMap() {
                return true; //skips loading from file
            }
        }
        command = new MoveCommand(worldMap,player, 0); // North
    }

    @Test
    void execute_CANmoveNorth() {
        String result = command.execute();
        assertEquals("Moved to Royal Woods", result);
        assertEquals(2, worldMap.getCurrentPosition().getId());
    }

    @Test
    void execute_FailedMoveSouth() {
        command.setDirection(1); // South
        String result = command.execute();
        assertEquals("Cannot move in that direction.", result);
        assertEquals(1, worldMap.getCurrentPosition().getId());
    }

    @Test
    void setDirection_ChangesMovementDirection() {
        command.setDirection(0); // North
        command.execute(); // Move to Royal Woods
        command.setDirection(1); // South
        assertEquals("Moved to Church", command.execute());
    }

    @Test
    void undo_ReturnsEmptyString() {
        assertEquals("", command.undo());
    }

    @Test
    void exit_ReturnsFalse() {
        assertFalse(command.exit());

    }
}

