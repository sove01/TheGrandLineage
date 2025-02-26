import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapLogic {
    private int RandomSpawn = 0; // start
    private int currentLocation = RandomSpawn;
    private int nextLocation; // from start

    public MapLogic() {

    }

    public boolean LoadMap(){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\map.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] tokens = line.split(";");

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // after starting the game, locations and paths will be intialised
//    ArrayList<String> ListOfLocations = new ArrayList<>();
//
//    public String map() {
//        try (BufferedReader br = new BufferedReader(new FileReader("src\\Map.txt"))) {
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                ListOfLocations.add(line);
//            }
//            return ListOfLocations.toString();
//        } catch (
//                Exception e) {
//
//        }
//        return "No locations were found";
//    }
}
