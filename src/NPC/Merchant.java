package NPC;

import Inventory.Player;

/**
 * An NPC that buys trinkets from players for silver.
 * Removes one trinket from inventory and gives fixed silver amount.
 */
public class Merchant extends NPC {
    private final int trinketValue = 10; // Fixed price per trinket

    /**
     * Creates a merchant NPC.
     *
     * @param name Merchant's name
     * @param dialogue Greeting message
     */
    public Merchant(String name, String dialogue) {
        super(name, dialogue, "Merchant");
    }

    /**
     * Buys first trinket in player's inventory.
     *
     * @param player The player to trade with
     */
    @Override
    public void interact(Player player) {
        super.interact(player); // Show dialogue

        if (!player.getInventory().getItems().isEmpty()) {
            System.out.println("I'll buy your trinkets");
            player.plusSilver(trinketValue);
            player.getInventory().removeItem(
                    player.getInventory().getItems().get(0));
            System.out.println("Sold for " + trinketValue + " silver");
        } else {
            System.out.println("You have nothing to sell");
        }
    }
}