package Command;

public class HelpCommand implements Command{

    @Override
    public String execute() {
        System.out.println("List of commands :");
        System.out.println("  exit -> Exit the program");
        System.out.println("  move -> Move to the next region/town");
        System.out.println("  pickup -> Pick up an object");
        System.out.println("  interact -> Interact with an object");
        System.out.println("  inventory -> Displays inventory");
        System.out.println("  history -> Displays history");
        System.out.println("  useArtifact -> consumes artifact if requirements are met");
        return "";
    }

    @Override
    public String undo() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
