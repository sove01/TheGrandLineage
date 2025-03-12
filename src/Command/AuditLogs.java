package Command;

public class AuditLogs implements Command {

    @Override
    public String execute() {
        return "";
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
