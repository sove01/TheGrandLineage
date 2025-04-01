package Inventory.Artifact;

import Inventory.Item;
import Inventory.Player;

public class Artifact extends Item {
    private String Effect;

    public Artifact(String effect, String name, String description, int value) {
        super(name, description, true, value);
        Effect = effect;
    }

    @Override
    public String use(Player player) {
        return "Using artifact : " + getName() +
                "\n" + "Effect : " + Effect;
    }
}
