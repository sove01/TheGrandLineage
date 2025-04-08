package Command;

import Inventory.Player;
import NPC.GameObject;
import NPC.NPC;
import World.Location;

/**
 * Command for interacting with game objects.
 */

public class InteractCommand implements Command {
    private Player player;
    private Location location;
    private NPC npc;

    public InteractCommand(Player player, Location loc) {
        this.player = player;
        this.location = loc;
    }


    @Override
    public String execute() {
        if (!location.getNPCs().isEmpty()) {
            for (NPC npc : location.getNPCs()) {
                npc.interact(player);  // Interact with each NPC
            }
            return "Interacted with all NPCs in " + location.getName() + ".";
        } else {
            return "There are no NPCs to interact with in this location.";
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
