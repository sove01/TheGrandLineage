package Command;

import Inventory.Player;

import java.util.Scanner;

public class CreateCharacterCommand implements Command {
    private Player player;
    private Scanner scanner;

    public CreateCharacterCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        System.out.println("Enter the name of the character: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);

        return "Character created!" + player.getName();
    }

    @Override
    public String undo() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public Player getPlayer() {
        return player;
    }
}
