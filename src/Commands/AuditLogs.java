package Commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AuditLogs extends Command {

    @Override
    public String execute() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader history = new BufferedReader(new FileReader("historylog.txt"))) {
            String line = "";
            while (line != null) {
                list.add(line);

            }
            return history.toString();
        } catch (FileNotFoundException e) {
            return "File Not Found";
        } catch (IOException e) {
            return "IO Error";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
