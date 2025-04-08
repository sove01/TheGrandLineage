package Inventory;


import Command.Command;
import Inventory.Artifact.Artifact;
import Race.Race;

import Weaponry.*;
import Weaponry.Skill;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player character with inventory, stats, and progression systems.
 * Handles all player-specific operations including items, skills, and leveling.
 */
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

    /**
     * Creates a new player with default stats.
     *
     * @param name The player's name
     */
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

    public void saveProgressToCSV() {
        String path = "playerProgress.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            File file = new File("playerProgress.csv");
            if (file.length() == 0) {
                writer.write("Name,Experience,Health,Inventory,LearnedSkills\n");
            }

            StringBuilder inventoryItems = new StringBuilder();
            for (Item item : inventory.getItems()) {
                inventoryItems.append(item.getName()).append(";");
            }

            StringBuilder skills = new StringBuilder();
            for (Weaponry.Skill skill : learnedSkills) {
                skills.append(skill.getSkillName()).append(";");
            }

            writer.write(name + ","
                    + experience + ","
                    + health + ","
                    + inventoryItems.toString() + ","
                    + skills.toString() + "\n");

            System.out.println("Player progress saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving player progress: " + e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Adds an item to inventory via command pattern.
     *
     * @param item The item to add
     */
    public void addItem(Item item) {
        Command itemUsageCommand = new ItemUsage(this, item);
        itemUsageCommand.execute();
    }

    public void displayInventory() {
        inventory.displayInventory();
    }

    /**
     * Picks up an item and adds to inventory.
     *
     * @param item The item to pick up
     */
    public void pickup(Item item) {
        inventory.addItem(item);
        System.out.println("Picked up " + item.getName());
    }

    /**
     * Applies an artifact's effect.
     *
     * @param artifact The artifact to use
     * @return Effect description
     */
    public String applyArtifactEffect(Artifact artifact) {
        return "Applying artifact effect:" + artifact.getName();
    }

    /**
     * Modifiers for currency
     */
    public void plusSilver(int amount) {
        this.silver += amount;
    }

    /**
     * Modifiers for currency
     */
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

    /**
     * Checks and handles class progression
     */
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

    /**
     * Gains experience and checks for level up.
     *
     * @param value EXP amount to add
     */
    public void gainEXP(int value) {
        this.experience += value;
        checkClassUpgrade();
    }

    /**
     * Restores health (capped at 100).
     *
     * @param value Health amount to restore
     */
    public void restoreHealth(int value) {
        this.health += value;
        if (health > 100) health = 100;
        System.out.println("Health restored to " + health);

    }

    /**
     * Uses a learned skill.
     *
     * @param index Skill slot number
     * @return Skill effect or error message
     */
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


