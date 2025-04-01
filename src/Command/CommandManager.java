package Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps tracks of all commands
 */

public class CommandManager {
    private Map<String, Command> commands = new HashMap<>();
    private History history = new History();

    /**
     * Adds a new command to our collection.
     *
     * @param commandName What you'll type to call this command.
     * @param command     The actual command.
     */
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Runs a command and adds to history ( in case we want to undo )
     *
     * @param commandName The name of the command to execute
     * @return true if this command should make the program quit, false otherwise
     */
    public boolean executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            String result = command.execute();
            System.out.println(result);
            history.addCommand(command);
            return command.exit();
        } else {
            System.out.println("Unknown command.");
            return false;
        }
    }

    /**
     * Gets our command history - basically the list of everything we've done.
     *
     * @return The history object of our commands.
     */

    public History getHistory() {
        return history;
    }

    /**
     * gets all registered commands.
     *
     * @return A HashMap of all commands.
     */
    public HashMap<String, Command> getCommands() {
        return (HashMap<String, Command>) commands;
    }
}
