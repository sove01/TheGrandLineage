package NPC;

import Inventory.Player;

/**
 * An NPC that provides quests and rewards based on player alignment.
 * Grants XP and alignment points when interacted with.
 */
public class QuestGiver extends NPC {

    /**
     * Creates a new quest-giving NPC.
     *
     * @param name NPC's name
     * @param dialogue Introduction message
     */
    public QuestGiver(String name, String dialogue) {
        super(name, dialogue, "questgiver");
    }

    /**
     * Offers quest rewards based on player alignment.
     *
     * @param player The interacting player
     */
    @Override
    public void interact(Player player) {
        System.out.println("Complete a quest and gain XP!");

        if (player.getAlignment().equals("Orderly")) {
            player.increaseOrderlyPoints(10);
            player.gainEXP(50);
            System.out.println("Gained 10 Orderly Points and 50 XP!");
        } else if (player.getAlignment().equals("Chaotic")) {
            player.increaseChaoticPoints(10);
            player.gainEXP(50);
            System.out.println("Gained 10 Chaotic Points and 50 XP!");
        }
    }
}