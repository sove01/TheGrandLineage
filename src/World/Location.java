package World;

import Inventory.Player;
import NPC.NPC;

import java.util.ArrayList;

public class Location {
    private String name;
    private int id;
    private int[] directions; // [North, South, East, West]
    private Region region;
    private ArrayList<String> items = new ArrayList<>();
    private NPC npc;
    private int EXPRewards;

    public Location(String name, int id, int[] directions, Region region) {
        this.name = name;
        this.id = id;
        this.directions = directions;
        this.region = region;
    }

    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    public void interact(Player player) {
        if(npc != null){
            npc.interact(player);
            player.gainEXP(EXPRewards);
        }
    }
    public void addItem(String item) {
        items.add(item);
    }

    public ArrayList<String> getItems() {
        return items;
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
