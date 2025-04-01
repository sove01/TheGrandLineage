package NPC;

import Inventory.Player;

/**
 * A healing NPC that restores player health for a fee.
 * Charges 10 silver for full health restoration.
 */
public class Doctor extends NPC {

    /**
     * Creates a new Doctor NPC.
     *
     * @param name     The doctor's name
     * @param dialogue Greeting dialogue
     */
    public Doctor(String name, String dialogue) {
        super(name, dialogue, "Healer");
    }

    /**
     * Heals player if they can pay, displays appropriate messages.
     *
     * @param player The player to interact with
     */
    @Override
    public void interact(Player player) {
        super.interact(player);  // Shows dialogue
        // Fixed healing cost
        int cost = 10;
        if (player.getSilver() >= cost) {
            player.minusSilver(cost);
            player.restoreHealth(100);  // Full heal
            System.out.println("You are now fully healed!");
        } else {
            System.out.println("Not enough silver (Cost: " + cost + ")");
        }
    }
}