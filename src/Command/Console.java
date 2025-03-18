package Command;

import Inventory.Player;
import World.WorldMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;


    HashMap<String, Command> Prompts;
    private WorldMap map;
    private Player player;
    private CommandManager manager;

    public Console() {
        this.manager = new CommandManager();
        initialize();
    }

    private void initialize() {
        map = new WorldMap();
        if (!map.loadMap()) {
            System.out.println("Map is not loaded");
            exit = true;
            return;
        }

        CreateCharacterCommand createCharacterCommand = new CreateCharacterCommand(sc);
        createCharacterCommand.execute();

        Prompts = new HashMap<>();
        Prompts.put("exit", new ExitCommand());
        Prompts.put("move", new MoveCommand(map, -1));
        Prompts.put("pickup", new PickUpCommand(player, null));
        Prompts.put("interact", new InteractCommand(player, null));
        Prompts.put("inventory", new InventoryCommand(player));
        Prompts.put("history", new HistoryCommand(manager));

    }

    private void provedPrompt() {
        System.out.println("Enter your command: ");
        System.out.println(">");
        try {
            String inputPrompt = sc.nextLine();

            if (Prompts.containsKey(inputPrompt)) {
                Command cmd = Prompts.get(inputPrompt);

                if (cmd instanceof MoveCommand) {
                    int direction = -1;
                    while (direction < 0 || direction > 3) {
                        System.out.println("Which direction? (0: North, 1: South, 2: East, 3: West)");
                        if (sc.hasNextInt()) {
                            direction = sc.nextInt();
                            sc.nextLine();
                            if (direction < 0 || direction > 3) {
                                System.out.println("Invalid direction. Please enter a number between 0 and 3.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            sc.nextLine();
                        }
                    }
                    ((MoveCommand) cmd).setDirection(direction);
                }

                System.out.println(Prompts.get(inputPrompt).execute());
                exit = cmd.exit();
            } else {
                System.out.println("Invalid prompt");
            }
        } catch (Exception e) {
            System.out.println("Invalid prompt" + e.getMessage());
        }
    }

    public void start() {
        initialize();
        do {
            provedPrompt();
        } while (!exit);
    }

}
