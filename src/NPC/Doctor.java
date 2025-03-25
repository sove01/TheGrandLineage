package NPC;

import Inventory.Player;

public class Doctor extends NPC{
    private int cost = 10;

    public Doctor(String name, String dialogue) {
        super(name, dialogue, "Healer");
    }

    @Override
    public void interact(Player player) {
        super.interact(player);
        if(player.getSilver() >= cost){
            player.minusSilver(cost);
            player.restoreHealth(100);
            System.out.println("You are now healed");
        } else {
            System.out.println("Not enough silver");
        }
    }
}
