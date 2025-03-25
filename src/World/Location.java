package World;

import Inventory.Item;
import Inventory.Player;
import NPC.NPC;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private int id;
    private int[] directions; // [North, South, East, West]
    private Region region;
    private NPC npc;
    private int EXPRewards;
    private List<Item> items;

    public Location(String name, int id, int[] directions, Region region) {
        this.name = name;
        this.id = id;
        this.directions = directions;
        this.region = region;
        this.items = new ArrayList<>();
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    public void interact(Player player) {
        if (npc != null) {
            npc.interact(player);
            player.gainEXP(EXPRewards);
        }
    }

    public void trinketInteract(Player player) {
        if(!items.isEmpty()) {
            Item item = items.get(0);
            player.pickup(item);
            items.remove(item);
            System.out.println("You picked up:" + item.getName());
        } else {
            System.out.println("no trinkets to pick up here");
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getDirection(int index) {
        return directions[index]; // 0 = North, 1 = South, 2 = East, 3 = West
    }

    public Region getRegion() {
        return region;
    }
}
