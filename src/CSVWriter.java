import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_DELIMITER = "\n";

    public static void writeCSV(String filename, ArrayList<Record> records) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filename);

            for(Record record : records) {
                fileWriter.append(record.getImapHost());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(record.getImapPort()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(record.getUseSSL()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(record.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(record.getPassword());
                fileWriter.append(NEW_LINE_DELIMITER);
            }
        } catch (Exception ex) {
            System.out.println("Error: Could not write to " + filename);
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error: Could not flush " + filename);
                ex.printStackTrace();
            }
        }
    }
}
