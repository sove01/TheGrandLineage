package Inventory;

public abstract class Item {
    protected String name;
    protected String description;
    protected boolean isConsumable;
    private int value;

    public Item(String name, String description, boolean isConsumable, int value) {
        this.name = name;
        this.description = description;
        this.isConsumable = isConsumable;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isConsumable() {
        return isConsumable;
    }

    public int getValue() {
        return value;
    }

    public abstract String use(Player player);

    public String displayItemDetails() {
        return "Name: " + name + "\nDescription: " + description + "\nValue: " + value + " silver";
    }
}
