package Command;

import Inventory.Artifact.Artifact;
import Inventory.Player;

import java.util.ArrayList;

/**
 * Handles using artifacts from player's inventory.
 * Supports both specific artifact usage and general artifact management.
 */
public class UseArtifactCommand implements Command {
    private Player player;
    private Artifact artifact;
    private ArrayList<String> artifacts = new ArrayList<String>();

    /**
     * Creates command for specific artifact usage.
     *
     * @param player   The player using the artifact
     * @param artifact The artifact to be used
     */
    public UseArtifactCommand(Player player, Artifact artifact) {
        this.player = player;
        this.artifact = artifact;
    }

    /**
     * Creates command for general artifact management.
     *
     * @param player The player whose artifacts will be managed
     */
    public UseArtifactCommand(Player player) {
        this.player = player;
        this.artifact = null;
    }

    @Override
    public String execute() {
        if (artifact != null) {
            artifact.use(player);
            return "Used artifact: " + artifact.getName();
        }
        return "No artifact found";
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