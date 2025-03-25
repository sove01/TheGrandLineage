package NPC;

import Inventory.Player;

public abstract class GameObject {
    private String name;

    public String getDialogue() {
        return dialogue;
    }

    private String dialogue;

    public GameObject(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public abstract void interact(Player player);
}
