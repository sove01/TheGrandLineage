package NPC;

import Inventory.Player;

public class Merchant extends NPC {
    private int trinketValue = 10;

    public Merchant(String name, String dialogue) {
        super(name, dialogue, "Merchant");
    }

    @Override
    public void interact(Player player) {
        super.interact(player);
        if (!player.getInventory().getItems().isEmpty()) {
            System.out.println("Buying your trinkets");
            player.plusSilver(trinketValue);
            player.getInventory().removeItem(player.getInventory().getItems().get(0));
            System.out.println("You sold a trinket and got " + trinketValue + " silver.");

        }
    }
}
