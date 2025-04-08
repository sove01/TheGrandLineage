package Command;

import Inventory.Player;
import World.Location;
import World.WorldMap;

/**
 * Handles player movement between locations in the game world.
 * Validates movement and returns appropriate status messages.
 */
public class MoveCommand implements Command {
    private WorldMap map;
    private int direction;
    private Player player;

    /**
     * @param map The game world map
     * @param direction Initial movement direction
     */
    public MoveCommand(WorldMap map, int direction) {
        this.map = map;
        this.direction = direction;
    }

    /**
     * Updates the movement direction.
     *
     * @param direction New direction to move (0-3)
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Attempts to move player in specified direction.
     *
     * @return Success/failure message with location name or error
     */
    @Override
    public String execute() {
        if (map.move(direction)) {
            Location currentLocation = map.getCurrentPosition();
            currentLocation.spawnTrinketsInLocation(player);
            return "Moved to " + currentLocation.getName();
        } else {
            return "Cannot move in that direction. " + direction;
        }
    }

    /**
     * @return Empty string
     */
    @Override
    public String undo() {
        return "";
    }

    /**
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}