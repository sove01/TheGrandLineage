package Command;

import Inventory.Player;
import World.WorldMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Handles game commands and player input.
 */
public class Console {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;

    HashMap<String, Command> Prompts; // Available commands
    private WorldMap map; // Game world
    private Player player; // Player data
    private CommandManager manager; // Command handler

    public Console() {
        this.manager = new CommandManager();
    }

    /**
     * Loads map and registers commands.
     */
    private void initialize() {
        System.out.println("Welcome to the grand lineage");
        map = new WorldMap();
        if (!map.loadMap()) {
            System.out.println("Map load failed");
            exit = true;
            return;
        }

        Prompts = new HashMap<>();
        Prompts.put("help", new HelpCommand());
        Prompts.put("exit", new ExitCommand());
        Prompts.put("move", new MoveCommand(map,player, -1));
        Prompts.put("pickup", new PickUpCommand(player, null));
        Prompts.put("interact", new InteractCommand(player, null));
        Prompts.put("inventory", new InventoryCommand(player));
        Prompts.put("history", new HistoryCommand(manager));
        Prompts.put("useArtifact", new UseArtifactCommand(player));
        Prompts.put("new lineage", new CreateCharacterCommand(sc));
    }

    /**
     * Processes player input and executes commands.
     */
    private void provedPrompt() {
        System.out.print("> ");
        try {
            String input = sc.nextLine();
            if (Prompts.containsKey(input)) {
                Command cmd = Prompts.get(input);

                if (cmd instanceof MoveCommand) {
                    int direction = -1;
                    while (direction < 0 || direction > 3) {
                        map.displayMap();
                        System.out.print("Direction (0-3): ");
                        if (sc.hasNextInt()) direction = sc.nextInt();
                        sc.nextLine();
                    }
                    ((MoveCommand) cmd).setDirection(direction);
                }

                System.out.println(cmd.execute());
                exit = cmd.exit();
            } else {
                System.out.println("Unknown command");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Starts and runs the game loop.
     */
    public void start() {
        initialize();
        while (!exit) provedPrompt();
    }
}