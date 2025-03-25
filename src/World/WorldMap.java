package World;

import Inventory.Trinket;
import NPC.Doctor;
import NPC.Merchant;
import NPC.SuperClassNPC;
import NPC.UltraClassNPC;
import Weaponry.UltraClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WorldMap {
    private HashMap<String, Region> regions = new HashMap<>();
    private HashMap<Integer, Location> world = new HashMap<>();
    private int currentPosition;
    //    private ArrayList<String> trinkets = new ArrayList<>();
    private Random rand = new Random();

    private void AddRandomTrinketsToLocations() {
        for (Location loc : world.values()) {
            if (rand.nextInt(100) < 30) {
                spawnTrinkets(loc);
            }
        }
    }

    private void spawnTrinkets(Location location) {
        String[] trinketNames = {"Old Amulet", "Old Ring", "Idol of the forgotten", "Opal", "Ruby", "Emerald", "Diamond"};
        int[] trinketValues = {4, 5, 6, 10, 15, 100, 150};

        String trinketName = trinketNames[rand.nextInt(trinketNames.length)];
        int trinketValue = trinketValues[rand.nextInt(trinketValues.length)];

        Trinket trinket = new Trinket(trinketName, "A valueable trinket", false, trinketValue);
        location.addItems(trinket);
        System.out.println("A " + trinketName + "has spawned in " + location.getName());

    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/World/Map.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Ignore empty lines and comments
                if (line.startsWith("#") || line.trim().isEmpty()) continue;

                String[] lines = line.split(";");

                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                int[] directions = new int[4];

                for (int i = 0; i < 4; i++) {
                    directions[i] = Integer.parseInt(lines[i + 2]);
                }

                String regionName = lines[6];
                Region region = regions.computeIfAbsent(regionName, Region::new);

                Location location = new Location(name, id, directions, region);
                region.addLocation(location);
                world.put(id, location);
            }

            // Random spawn
            addNPCsToAllLocations();
            addClassTrainers();
            setRandomStart();
            return true;

        } catch (IOException e) {
            System.out.println("Error loading map: " + e.getMessage());
            return false;
        }
    }

    private void addNPCsToAllLocations() {
        // = all locations
        for (Location location : world.values()) {
            location.setNPC(new Doctor("Doctor", "I can heal your wounds for silver."));
            location.setNPC(new Merchant("Merchant", "Want to sell your trinkets?"));
        }
        addClassTrainers(); // = fixed location
    }

    private void addClassTrainers() {
        world.get(8).setNPC(new UltraClassNPC("Sentinel of Light", "I will train you for Ultra Class!", "UltraClass"));
        world.get(9).setNPC(new SuperClassNPC("Necrotower Guard", "I will train you for Super Class.", "SuperClass"));
        world.get(10).setNPC(new UltraClassNPC("Oresfall Elder", "I will help you ascend to Ultra Class.", "UltraClass"));
        world.get(11).setNPC(new SuperClassNPC("Tundra Warrior", "I can train you for Super Class.", "SuperClass"));
    }

    private void setRandomStart() {
        Random rand = new Random();
        // Gets all IDS of locations
        Object[] keys = world.keySet().toArray();
        // Chooses random ID
        currentPosition = (int) keys[rand.nextInt(keys.length)];
    }

    public Location getCurrentPosition() {
        return world.get(currentPosition);
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }

    public HashMap<String, Region> getRegions() {
        return regions;
    }

    public void displayMap() {
        System.out.println("Displaying map...");

        if (world.isEmpty()) {
            System.out.println("No map loaded. Please load the map first.");
            return;
        }

        System.out.println("Map loaded successfully!\n");
        System.out.println("Trinkets spotted in this area:");

        System.out.println("Regions and their locations:");
        System.out.println("--------------------------------");

        for (Region region : regions.values()) {
            System.out.println("Region: " + region.getName());
            for (Location location : region.getLocations()) {
                System.out.println("  - " + location.getName() + " (ID: " + location.getId() + ")");
            }
            System.out.println();
        }

        // Shows current position
        Location current = getCurrentPosition();
        System.out.println("Current Position (Random Spawn):");
        System.out.println("  - Location: " + current.getName());
        System.out.println("  - Region: " + current.getRegion().getName());
        System.out.println("  - Next location: [North: " + current.getDirection(0) + ", South: " + current.getDirection(1) + ", East: " + current.getDirection(2) + ", West: " + current.getDirection(3) + "]");

    }

    public boolean move(int direction) {
        Location current = getCurrentPosition();
        int nextLocationID = current.getDirection(direction);

        if (nextLocationID != -1 && world.containsKey(nextLocationID)) {
            this.currentPosition = nextLocationID;
            return true;
        } else {
            System.out.println("Failed to move direction: " + direction);
            return false;
        }
    }
}
