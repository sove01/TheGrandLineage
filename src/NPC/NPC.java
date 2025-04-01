package NPC;

import Inventory.Player;

/**
 * Base class for non-player characters with specialized roles.
 * Handles common NPC behaviors and role-specific interactions.
 */
public class NPC extends GameObject {
    private final String role;  // specialized roles

    /**
     * Creates a new NPC.
     *
     * @param name NPC's name
     * @param dialogue Default interaction text
     * @param role NPC's role
     */
    public NPC(String name, String dialogue, String role) {
        super(name, dialogue);
        this.role = role;
    }

    /**
     * @return The NPC's specialized role
     */
    public String getRole() {
        return role;
    }

    /**
     * Handles player interaction with their role responses.
     *
     * @param player The interacting player
     */
    @Override
    public void interact(Player player) {
        System.out.println(getDialogue());  // Show base dialogue

        // Role-specific additional dialogue
        if ("Merchant".equalsIgnoreCase(role)) {
            System.out.println("I buy trinkets - show me what you've got!");
        } else if ("Healer".equalsIgnoreCase(role)) {
            System.out.println("I can heal your wounds for a small fee");
        }
    }
}