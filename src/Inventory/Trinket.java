package Inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Valuable but non-functional items that can be sold to merchants.
 * Trinkets provide no gameplay effects beyond their monetary value.
 */
public class Trinket extends Item {
    private int SilverValue;

    public Trinket(String name, String description, boolean isConsumable, int value) {
        super(name, description, false, value);
        this.SilverValue = value;
    }

    @Override
    public String use(Player player) {
        return "This item doesn't have any effects, only for selling to the Merchant";
    }

    public int getSilverValue() {
        return SilverValue;
    }

    public static void saveTrinketToCSV(Trinket trinket, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            File file = new File(filePath);
            // Write header if the file is empty
            if (file.length() == 0) {
                writer.write("Name,Description,Value\n");
            }
            writer.write(trinket.getName() + "," + trinket.getDescription() + "," + trinket.getValue() + "\n");
            System.out.println("Saved trinket: " + trinket.getName());
        } catch (IOException e) {
            System.out.println("Error saving trinket: " + e.getMessage());
        }

    }

    public static List<Trinket> loadTrinketsFromCSV(String filePath) {
        List<Trinket> trinkets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String description = data[1];
                    int value = Integer.parseInt(data[2]);
                    Trinket trinket = new Trinket(name, description, false, value);
                    trinkets.add(trinket);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading trinkets: " + e.getMessage());
        }
        return trinkets;
    }
}

