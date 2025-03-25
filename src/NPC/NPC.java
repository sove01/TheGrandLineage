package NPC;

import Inventory.Player;

public class NPC extends GameObject {
    private String role;

    public NPC(String name, String dialogue, String role) {
        super(name, dialogue);
        this.role = role;
    }

    public String getRole() {
        return role;
    }


    public void interact(Player player) {
        System.out.println(getDialogue());
        if ("Merchant".equalsIgnoreCase(role)) {
            System.out.println("I can buy those trinkets off you");
        } else if ("Healer".equalsIgnoreCase(role)) {
            System.out.println("I can heal you");
        }
    }

    ;
}
