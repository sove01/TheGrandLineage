package NPC;

import Inventory.Player;

public class QuestGiver extends NPC{

    public QuestGiver(String name, String dialogue) {
        super(name, dialogue, "questgiver" );
    }

    @Override
    public void interact(Player player) {
        System.out.println("Complete a quest and gain XP");
        if(player.getAlignment().equals("Orderly")){
            player.increaseOrderlyPoints(10);
            player.gainEXP(50);
        } else if (player.getAlignment().equals("Chaotic")){
            player.increaseChaoticPoints(10);
            player.gainEXP(50);
        }

    }
}
