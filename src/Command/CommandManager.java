package Command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commands = new HashMap<>();
    private History history = new History();

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

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

    public History getHistory() {
        return history;
    }

    public HashMap<String, Command> getCommands() {
        return (HashMap<String, Command>) commands;
    }
}
