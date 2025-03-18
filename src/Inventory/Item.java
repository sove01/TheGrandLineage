package Inventory;

public abstract class Item {
    protected String name;
    protected String description;
    protected boolean isConsumable;

    public Item(String name, String description, boolean isConsumable) {
        this.name = name;
        this.description = description;
        this.isConsumable = isConsumable;
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

    public abstract String use(Player player);
}
