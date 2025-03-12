package Command;

import Command.Inventory.Inventory;
import Command.Inventory.Item;
import Command.Inventory.ItemUsage;
import Command.Inventory.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;

    HashMap<String, Command> Prompts;

    private void initialize() {
        Prompts = new HashMap<>();
        Prompts.put("exit", new Exit());
//        Prompts.put("UseItem",)
//        Prompts.put("inventory", new Inventory());

    }

    private void provedPrompt() {
        System.out.println(">");
        String inputPrompt = sc.nextLine();

        if (Prompts.containsKey(inputPrompt)) {
            System.out.println(Prompts.get(inputPrompt).execute());
            exit = Prompts.get(inputPrompt).exit();
        } else {
            System.out.println("Invalid prompt");
        }
    }

    public void start() {
        initialize();
        do {
            provedPrompt();
        } while (!exit);
    }

}
