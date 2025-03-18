package Command;

public class HistoryCommand implements Command {
    private CommandManager manager;

    public HistoryCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute() {
        manager.getHistory().displayHistory();
        return "Command history : ";
    }

    @Override
    public String undo() {

        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
