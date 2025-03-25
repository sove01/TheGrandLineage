package Inventory;

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
}
