package NPC;

import Inventory.Player;

/**
 * Base class for all interactable game objects (NPCs, items, etc.).
 * Defines core properties and interaction behavior that all game objects must implement.
 */
public abstract class GameObject {
    private String name;
    private String dialogue;

    /**
     * Creates a new game object with basic properties.
     *
     * @param name The object's name
     * @param dialogue Default interaction text
     */
    public GameObject(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    /**
     * @return The object's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The default interaction dialogue
     */
    public String getDialogue() {
        return dialogue;
    }

    /**
     * Handles player interaction with this object.
     *
     * @param player The player interacting with the object
     */
    public abstract void interact(Player player);
}