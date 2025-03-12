package Command.Inventory;

import Command.ClassSkillsWeaponRelatedCommands.Player;

public abstract class Item {
    private String name;
    private String description;
    private boolean isConsumable;

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

    public abstract void use(Player player);
}
