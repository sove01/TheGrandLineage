import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MapLogic {
    private int RandomSpawn; // start
    private int currentLocation;
    private int nextLocation; // from start

    public MapLogic() {

    }

    // after starting the game, locations and paths will be intialised
    ArrayList<String> ListOfLocations = new ArrayList<>();

    public String map() {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Map.csv"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                ListOfLocations.add(line);
            }
            return ListOfLocations.toString();
        } catch (
                Exception e) {

        }
        return "No locations where found";
    }
}
