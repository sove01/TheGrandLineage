package Command;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
        logCommand(command); // Add this line
    }

    private void logCommand(Command command) {
        try (FileWriter writer = new FileWriter("historylog.txt", true)) {
            writer.write(command.getClass().getSimpleName() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to history log: " + e.getMessage());
        }
    }

    public void displayHistory() {
        if (commands.isEmpty()) {
            System.out.println("No history available.");
            return;
        }

        System.out.println("Command History:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ". " + commands.get(i).getClass().getSimpleName());
        }
    }

    public Command getCommand(int index) {
        if (index >= 0 && index < commands.size()) {
            return commands.get(index);
        }
        return null;
    }

    public int size() {
        return commands.size();
    }
}
