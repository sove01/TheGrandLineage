package World;

public class Location {
    private String name;
    private int id;
    private int[] directions; // [North, South, East, West]
    private Region region;

    public Location(String name, int id, int[] directions, Region region) {
        this.name = name;
        this.id = id;
        this.directions = directions;
        this.region = region;
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
