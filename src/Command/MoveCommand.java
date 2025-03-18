package Command;

import World.Location;
import World.WorldMap;

public class MoveCommand implements Command {
    private WorldMap map;
    private int direction;

    public MoveCommand(WorldMap map, int direction) {
        this.map = map;
        this.direction = direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String execute() {
        if (map.move(direction)) {
            Location currentLocation = map.getCurrentPosition();
//            return "Moved to " + map.getCurrentPosition().getName() + ".";
            return "Moved to " + currentLocation.getName();
        } else {
            return "Cannot move in that direction. " + direction;
        }
    }

    @Override
    public String undo() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
