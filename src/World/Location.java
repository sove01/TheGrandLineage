package World;

import Inventory.Item;
import Inventory.Player;
import NPC.NPC;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game location with items, NPCs, and navigation options.
 * Handles player interactions and item management within a specific area.
 */
public class Location {
    private String name;
    private int id;
    private int[] directions; // [North, South, East, West] - direction ids
    private Region region;
    private NPC npc;
    private int EXPRewards;
    private List<Item> items;

    /**
     * Creates a new game location.
     *
     * @param name       Location name
     * @param id         Unique identifier
     * @param directions Array of connected location IDs [N,S,E,W]
     * @param region     Parent region
     */

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

    /**
     * Assigns an NPC to this location.
     *
     * @param npc The NPC to place
     */
    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    /**
     * Handles player interaction with location's NPC.
     *
     * @param player The interacting player
     */
    public void interact(Player player) {
        if (npc != null) {
            npc.interact(player);
            player.gainEXP(EXPRewards);
        }
    }

    /**
     * Picks up first available trinket at location.
     *
     * @param player The looting player
     */
    public void trinketInteract(Player player) {
        if (!items.isEmpty()) {
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

    public void removeItems(Item item) {
        items.remove(item);
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    /**
     * Gets connected location ID in specified direction.
     *
     * @param index 0=North, 1=South, 2=East, 3=West
     * @return Destination location ID
     */
    public int getDirection(int index) {
        return directions[index]; // 0 = North, 1 = South, 2 = East, 3 = West
    }

    public Region getRegion() {
        return region;
    }
}
