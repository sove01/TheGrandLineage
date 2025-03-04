package World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class WorldMap {
    private HashMap<String, Region> regions = new HashMap<>();
    private HashMap<Integer, Location> world = new HashMap<>();
    private int currentPosition;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/World/Map.txt"))) {
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
            setRandomStart();
            return true;

        } catch (IOException e) {
            System.out.println("Error loading map: " + e.getMessage());
            return false;
        }
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


    }

