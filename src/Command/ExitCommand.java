package Command;

/**
 * Exits the game when executed.
 */
public class ExitCommand implements Command {
    /**
     * @return Exit message
     */
    @Override
    public String execute() {
        return "The lineage continues..";
    }

    /**
     * @return Empty string (no undo)
     */
    @Override
    public String undo() {
        return "";
    }

    /**
     * @return true (signals program to exit)
     */
    @Override
    public boolean exit() {
        return true;
    }
}