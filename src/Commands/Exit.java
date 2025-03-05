package Commands;

public class Exit extends Command {

    @Override
    public String execute() {
        return "The lineage continues...";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
