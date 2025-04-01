package Command;

import Inventory.Player;
import Race.*;

import java.util.Scanner;

/**
 * Handles character creation.
 */
public class CreateCharacterCommand implements Command {
    private Player player;
    private final Scanner scanner;

    /**
     * @param scanner For player input
     */
    public CreateCharacterCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Creates player with random race.
     *
     * @return Character creation message
     */
    @Override
    public String execute() {
        System.out.print("Character name: ");
        String name = scanner.nextLine();
        player = new Player(name);

        Race[] races = {new Dzin(), new Khan(), new Morvid(), new Castellan()};
        Race chosen = races[new java.util.Random().nextInt(races.length)];
        player.setRace(chosen);
        chosen.racesDescriptions(player);

        return String.format("%s the %s created", player.getName(), chosen.getRaceName());
    }

    /**
     * @return Empty (no undo)
     */
    @Override
    public String undo() {
        return "";
    }

    /**
     * @return false (never exits game)
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * @return Created player
     */
    public Player getPlayer() {
        return player;
    }
}