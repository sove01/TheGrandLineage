package Command;

import Command.Inventory.Player;

public abstract class GameObject {
    private String name;

    public GameObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void interact(Player player);
}
