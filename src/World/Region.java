package World;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game region containing multiple locations.
 * Serves as a container for interconnected game areas.
 */
public class Region {
    private final String name;
    private final List<Location> locations;

    /**
     * Creates a new game region.
     *
     * @param name The region's name
     */
    public Region(String name) {
        this.name = name;
        this.locations = new ArrayList<>();
    }

    /**
     * Adds a location to this region.
     *
     * @param location The Location object to add
     */
    public void addLocation(Location location) {
        locations.add(location);
    }

    /**
     * @return The region's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return List of locations in this region
     */
    public List<Location> getLocations() {
        return locations;
    }
}