package Command;

import Inventory.Player;
import Race.Castellan;
import Race.Dzin;
import Race.Khan;
import Race.Morvid;
import Race.Race;

import java.util.Scanner;

public class CreateCharacterCommand implements Command {
    private Player player;
    private final Scanner scanner;

    public CreateCharacterCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        System.out.println("Enter the name of the character: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);

        Race[] races = {new Dzin(), new Khan(), new Morvid(), new Castellan()};
        Race chosen = races[new java.util.Random().nextInt(races.length)];
        player.setRace(chosen);
        chosen.racesDescriptions(player);
        return "Your character name is " + player.getName() + " and your race is " +  chosen.getRaceName();
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
