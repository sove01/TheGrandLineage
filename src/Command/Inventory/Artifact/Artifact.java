package Command.Inventory.Artifact;

import Command.Inventory.Item;
import Command.Inventory.Player;

public class Artifact extends Item {
    private String Effect;

    public Artifact(String effect, String name, String description) {
        super(name, description, true);
        Effect = effect;
    }

    @Override
    public String use(Player player) {
        return "Using artifact : " + getName() +
                "\n" + "Effect : " + Effect;

    }
}
