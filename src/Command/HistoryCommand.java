package Command;

/**
 * Displays command execution history.
 */
public class HistoryCommand implements Command {
    private final CommandManager manager;

    /**
     * @param manager Provides access to command history
     */
    public HistoryCommand(CommandManager manager) {
        this.manager = manager;
    }

    /**
     * Shows command history.
     *
     * @return History header message
     */
    @Override
    public String execute() {
        manager.getHistory().displayHistory();
        return "Command history:";
    }

    /**
     * @return null (operation cannot be undone)
     */
    @Override
    public String undo() {
        return null;
    }

    /**
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}