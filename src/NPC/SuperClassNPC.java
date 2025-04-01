package NPC;

import Inventory.Player;

/**
 * Specialized NPC that provides Super Class training.
 * Guides players through advanced class progression.
 */
public class SuperClassNPC extends NPC {

    /**
     * Creates a Super Class trainer NPC.
     *
     * @param name NPC's name
     * @param dialogue Introduction message
     * @param role Trainer
     */
    public SuperClassNPC(String name, String dialogue, String role) {
        super(name, dialogue, role);
    }

    /**
     * Offers Super Class training guidance.
     *
     * @param player The player seeking training
     */
    @Override
    public void interact(Player player) {
        super.interact(player); // Shows NPC dialogue
        System.out.println("I can help you unlock your Super Class potential!");
    }
}