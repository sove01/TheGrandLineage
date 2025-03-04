package World;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name;
    private List<Location> locations;

    public Region(String name) {
        this.name = name;
        this.locations = new ArrayList<>();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public String getName() {
        return name;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
