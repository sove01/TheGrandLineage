package NPC;

import Inventory.Player;

/**
 * Same java doc as SuperClassNPC
 */
public class UltraClassNPC extends NPC {

    public UltraClassNPC(String name, String dialogue, String role) {
        super(name, dialogue, role);
    }

    public void interact(Player player) {
        super.interact(player);
        System.out.println("I will help you train for your ultra class");
    }
}