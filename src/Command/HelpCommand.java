package Command;

/**
 * Displays available game commands.
 */
public class HelpCommand implements Command {
    /**
     * Prints command list.
     *
     * @return Empty string
     */
    @Override
    public String execute() {
        System.out.println("Available commands:");
        System.out.println("exit       - Quit game");
        System.out.println("move       - Travel to new location");
        System.out.println("pickup     - Take item");
        System.out.println("interact   - Use object");
        System.out.println("inventory  - Show items");
        System.out.println("history    - Show command history");
        System.out.println("useArtifact- Consume artifact");
        System.out.println("new lineage- Create character");
        return "";
    }

    /**
     * @return Empty string (no undo)
     */
    @Override
    public String undo() {
        return "";
    }

    /**
     * @return false (doesn't exit game)
     */
    @Override
    public boolean exit() {
        return false;
    }
}