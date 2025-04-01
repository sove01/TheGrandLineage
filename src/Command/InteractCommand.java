package Command;

import Inventory.Player;
import NPC.GameObject;

/**
 * Command for interacting with game objects.
 */

public class InteractCommand implements Command {
    private Player player;
    private GameObject targetObject;

    public InteractCommand(Player player, GameObject targetObject) {
        this.player = player;
        this.targetObject = targetObject;
    }


    @Override
    public String execute() {
        return "Interacted with " + targetObject.getName() + ".";
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
