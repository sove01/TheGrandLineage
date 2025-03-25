package NPC;

import Inventory.Player;

public class SuperClassNPC extends NPC{

    public SuperClassNPC(String name, String dialogue, String role) {
        super(name, dialogue, role);
    }

    public void interact(Player player) {
        super.interact(player);
        System.out.println("I will help you train for your super class");
    }
}
