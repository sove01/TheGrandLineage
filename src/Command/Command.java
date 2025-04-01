package Command;

/**
 * The Command interface - blueprint for all commands in the program.
 * Any command we add needs to do these three things.
 */
public interface Command {

    /**
     * Executes the command.
     *
     * @return A string message.
     */
    String execute();


    /**
     * To be added.
     */
    String undo();


    /**
     * Checks if this command should make the program quit.
     *
     * @return true if you've reached ultra class, false otherwise
     */
    boolean exit();
}
