package World;

import Inventory.Item;
import Inventory.Player;
import Inventory.Trinket;
import NPC.NPC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private List<NPC> npcs;
    private Random rand = new Random();

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
        loadTrinketsFromCSV();
        this.npcs = new ArrayList<>();
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }


    public List<NPC> getNPCs() {
        return npcs;
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

    public void spawnTrinketsInLocation() {
        List<Trinket> trinkets = Trinket.loadTrinketsFromCSV("src/trinkets.csv");
        for (Trinket trinket : trinkets) {
            addItem(trinket);
        }
        System.out.println("Trinkets spawned in " + name + ":");
        for (Item item : items) {
            System.out.println("- " + item.getName() + ": " + item.getDescription() + " (Value: " + item.getValue() + ")");
        }
    }

    public void loadTrinketsFromCSV() {
        List<Trinket> loadedTrinkets = Trinket.loadTrinketsFromCSV("src/trinkets.csv");
        for (Trinket trinket : loadedTrinkets) {
            addItem(trinket);
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

    public List<Item> getItems() {
        return items;
    }

    public void interactWithNPCs(Player player) {
        for (NPC npc : npcs) {
            npc.interact(player);
        }

    }
}
