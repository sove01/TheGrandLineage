package Command;

import Inventory.Artifact.Artifact;
import Inventory.Player;

public class UseArtifactCommand implements Command {
    private Player player;
    private Artifact artifact;




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
