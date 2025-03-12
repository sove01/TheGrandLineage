package Command;

public class Exit implements Command{

    @Override
    public String execute() {
        return "The lineage continues..";
    }

    @Override
    public String undo() {
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
