package Inventory;


import Command.Command;
import Inventory.Artifact.Artifact;
import Race.Race;

import Weaponry.*;
import Weaponry.Skill;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private SuperClass superclass;
    private UltraClass ultraclass;
    private int silver;
    private Inventory inventory;
    private String name;
    private String equippedWeapon;
    private List<Weaponry.Skill> learnedSkills;
    private int experience;
    private Race race;
    private String alignment;
    private int health;
    private int orderlyPoints;
    private int chaoticPoints;


    // default stats
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.silver = 0;
        this.alignment = "neutral";
        this.equippedWeapon = "fist";
        this.experience = 0;
        this.learnedSkills = new ArrayList<>();
        this.inventory = new Inventory();
        this.inventory = new Inventory();
        this.chaoticPoints = 0;
        this.orderlyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) {
        Command itemUsageCommand = new ItemUsage(this, item);
        itemUsageCommand.execute();
    }

    public void displayInventory() {
        inventory.displayInventory();
    }


    public void pickup(Item item) {
        inventory.addItem(item);
        System.out.println("Picked up " + item.getName());
    }

    public String applyArtifactEffect(Artifact artifact) {
        return "Applying artifact effect:" + artifact.getName();
    }

    public void plusSilver(int amount) {
        this.silver += amount;
    }

    public void minusSilver(int amount) {
        this.silver -= amount;
        if (this.silver < 0) {
            this.silver = 0;
        }
    }

    public void increaseOrderlyPoints(int value) {
        this.orderlyPoints += value;
    }

    public void increaseChaoticPoints(int value) {
        this.chaoticPoints += value;
    }

    public void checkClassUpgrade() {
        if (experience >= 5000 && ultraclass == null) {
            ultraclass = new UltraClass(equippedWeapon, alignment);
            learnedSkills.addAll(ultraclass.getUltraSkills());
            System.out.println("You are now ultra class");
        } else if (experience >= 1000 && superclass == null) {
            superclass = new SuperClass(equippedWeapon, alignment);
            learnedSkills.addAll(superclass.getSuperSkills());
            System.out.println("You are now superclass");
        }
    }

    public void gainEXP(int value) {
        this.experience += value;
        checkClassUpgrade();
    }

    public void restoreHealth(int value) {
        this.health += value;
        if (health > 100) health = 100;
        System.out.println("Health restored to " + health);

    }

    public String useSkill(int index) {
        if (index > 0 && index < learnedSkills.size()) {
            return learnedSkills.get(index).use();
        }
        return "Wrong skill index";
    }

    public int getHealth() {
        return health;
    }

    public int getSilver() {
        return silver;
    }

    public int getOrderlyPoints() {
        return orderlyPoints;
    }

    public int getChaoticPoints() {
        return chaoticPoints;
    }


    public String getAlignment() {
        return alignment;
    }

    public List<Weaponry.Skill> getLearnedSkills() {
        return learnedSkills;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Item> getItems() {
        return inventory.getItems();
    }

    public void pickUpItem(Item item) {
        inventory.addItem(item);
    }

    public boolean hasItems(Item item) {
        return inventory.getItems().contains(item);
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getExperience() {
        return experience;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public void setEquippedWeapon(String equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }
}


