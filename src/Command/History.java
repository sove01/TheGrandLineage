package Command;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracks and logs command history.
 */
public class History {
    private List<Command> commands = new ArrayList<>();

    /**
     * Adds command to history and logs it.
     *
     * @param command Command to record
     */
    public void addCommand(Command command) {
        commands.add(command);
        logCommand(command);
    }

    /**
     * Writes command to log file.
     *
     * @param command Command to log
     */
    private void logCommand(Command command) {
        try (FileWriter writer = new FileWriter("historylog.txt", true)) {
            writer.write(command.getClass().getSimpleName() + "\n");
        } catch (IOException e) {
            System.err.println("Log error: " + e.getMessage());
        }
    }

    /**
     * Prints all executed commands.
     */
    public void displayHistory() {
        if (commands.isEmpty()) {
            System.out.println("No commands yet");
            return;
        }

        System.out.println("Command History:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ". " + commands.get(i).getClass().getSimpleName());
        }
    }

    /**
     * Gets command by index.
     *
     * @param index Command position
     * @return Command or null if invalid index
     */
    public Command getCommand(int index) {
        if (index >= 0 && index < commands.size()) {
            return commands.get(index);
        }
        return null;
    }

    /**
     * @return Number of stored commands
     */
    public int size() {
        return commands.size();
    }
}