package Command;

public interface Command {
    String execute();
    String undo();
    boolean exit();
}
