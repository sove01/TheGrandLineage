package Inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracks and manages a collection of game items.
 * Supports adding, removing, and displaying items.
 */
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println("- " + item.getName());
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
