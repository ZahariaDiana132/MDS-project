package ro.pao.application.csv;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientActionLogger {
    private static final String CSV_FILE_PATH = "C:\\Users\\diana\\IdeaProjects\\MDS-project\\clienti.csv";
    private static final String CSV_HEADER = "Action,Time";

    public void logAction(String actionName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            // Append the action and timestamp to the CSV file
            writer.println(actionName + "," + getCurrentTimestamp());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public void initializeLogFile() {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
//            // Write the CSV header to the file
//            writer.println(CSV_HEADER);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
