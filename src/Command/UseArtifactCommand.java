package Command;

import Inventory.Artifact.Artifact;
import Inventory.Player;

import java.util.ArrayList;

public class UseArtifactCommand implements Command {
    private Player player;
    private Artifact artifact;
    private ArrayList<String> artifacts = new ArrayList<String>();




    public UseArtifactCommand(Player player, Artifact artifact) {
        this.player = player;
        this.artifact = artifact;
    }

    public UseArtifactCommand(Player player) {
        this.player = player;
        this.artifact = null;
    }


    @Override
    public String execute() {
        artifact.use(player);
        return "";
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
