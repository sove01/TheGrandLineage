package World;

import Inventory.Trinket;
import NPC.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Manages the game world including regions, locations, NPCs, and player movement.
 * Loads and maintains the game map from file data.
 */
public class WorldMap {
    private final HashMap<String, Region> regions = new HashMap<>();
    private final HashMap<Integer, Location> world = new HashMap<>();
    private int currentPosition;
    private final Random rand = new Random();

    /**
     * Loads map data from CSV file and initializes world state.
     *
     * @return true if loading succeeded, false otherwise
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/World/Map.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;

                String[] lines = line.split(";");
                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                int[] directions = Arrays.stream(lines, 2, 6)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                String regionName = lines[6];

                Region region = regions.computeIfAbsent(regionName, Region::new);
                Location location = new Location(name, id, directions, region);
                region.addLocation(location);
                world.put(id, location);
            }

            initializeWorld();
            return true;
        } catch (IOException e) {
            System.err.println("Map loading failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Initializes NPCs, items and player starting position
     */
    private void initializeWorld() {
        spawnNPCs();
        addClassTrainers();
        setRandomStartPosition();
    }

    /**
     * Spawns trinkets randomly in 30% of locations
     */
    private void AddRandomTrinketsToLocations() {
        world.values().stream()
                .filter(loc -> rand.nextInt(100) < 30)
                .forEach(this::spawnTrinkets);
    }

    /**
     * Creates random trinket at specified location
     */
    private void spawnTrinkets(Location location) {
        String[] names = {"Old Amulet", "Old Ring", "Idol of the forgotten", "Opal", "Ruby", "Emerald", "Diamond"};
        int[] values = {4, 5, 6, 10, 15, 100, 150};

        int index = rand.nextInt(names.length);
        Trinket trinket = new Trinket(names[index], "Valuable trinket", false, values[index]);
        location.addItems(trinket);
        System.out.println(names[index] + " spawned in " + location.getName());
    }

    /**
     * Adds standard NPCs to all locations
     * only 2 at the moment ( being Doctor and Merchant )
     */
    private void spawnNPCs() {
        world.values().forEach(loc -> {
            loc.setNPC(new Doctor("Doctor", "I can heal your wounds for silver."));
            loc.setNPC(new Merchant("Merchant", "Want to sell your trinkets?"));
        });
    }

    /**
     * Places class trainers at specific locations
     * more to be added
     */
    private void addClassTrainers() {
        world.get(8).setNPC(new UltraClassNPC("Sentinel of Light", "Ultra Class trainer", "UltraClass"));
        world.get(9).setNPC(new SuperClassNPC("Necrotower Guard", "Super Class trainer", "SuperClass"));
        world.get(10).setNPC(new UltraClassNPC("Oresfall", "Ultra Class trainer", "UltraClass"));
        world.get(11).setNPC(new SuperClassNPC("Tundra Warrior", "Super Class trainer", "SuperClass"));
    }

    /**
     * Sets random starting position for player
     */
    private void setRandomStartPosition() {
        Integer[] keys = world.keySet().toArray(new Integer[0]);
        currentPosition = keys[rand.nextInt(keys.length)];
    }

    /**
     * Attempts to move player in specified direction.
     *
     * @param direction 0=North, 1=South, 2=East, 3=West
     * @return true if movement succeeded
     */
    public boolean move(int direction) {
        int nextId = getCurrentPosition().getDirection(direction);
        if (nextId != -1 && world.containsKey(nextId)) {
            currentPosition = nextId;
            return true;
        }
        return false;
    }

    /**
     * Displays current map state and player position
     */
    public void displayMap() {
        Location current = getCurrentPosition();
        System.out.println("\n=== CURRENT MAP ===");
        System.out.println("Current Position: " + current.getName() + " (Region: " + current.getRegion().getName() + ")");
        System.out.print("Exits: ");

        // Display directions available from current location
        StringBuilder directions = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int directionId = current.getDirection(i);
            if (directionId != -1 && world.containsKey(directionId)) {
                directions.append(getDirectionName(i)).append(": ").append(world.get(directionId).getName()).append(" ");
            }
        }
        System.out.println(directions);
    }

    // Accessors
    public Location getCurrentPosition() {
        return world.get(currentPosition);
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }

    public HashMap<String, Region> getRegions() {
        return regions;
    }

    private String getDirectionName(int direction) {
        switch (direction) {
            case 0:
                return "North";
            case 1:
                return "South";
            case 2:
                return "East";
            case 3:
                return "West";
            default:
                return "";
        }
    }
}