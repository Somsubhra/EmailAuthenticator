import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read CSV File
 */
public class CSVReader {

    /**
     * Constant definitions
     */
    private static final String COMMA_DELIMITER = ",";

    private static final int HOST_IDX = 0;
    private static final int PORT_IDX = 1;
    private static final int SSL_IDX = 2;
    private static final int EMAIL_IDX = 3;
    private static final int PASS_IDX = 4;

    /**
     * Read CSV file
     */
    public static ArrayList<Record> readCSV(String filename) {
        BufferedReader fileReader = null;

        try {
            ArrayList<Record> records = new ArrayList<>();
            String line = "";

            fileReader = new BufferedReader(new FileReader(filename));

            while((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);

                if(tokens.length > 0) {
                    boolean ssl = false;
                    if(tokens[SSL_IDX].toLowerCase().equals("false")) {
                        ssl = false;
                    } else if(tokens[SSL_IDX].toLowerCase().equals("true")) {
                        ssl = true;
                    }

                    Record record = new Record.Builder(tokens[HOST_IDX])
                            .port(Integer.parseInt(tokens[PORT_IDX]))
                            .ssl(ssl)
                            .email(tokens[EMAIL_IDX])
                            .password(tokens[PASS_IDX])
                            .build();

                    records.add(record);
                }
            }

            return records;

        } catch (Exception ex) {
            System.out.println("Error: Could not read " + filename);
            ex.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                System.out.println("Error: Could not close " + filename);
                ex.printStackTrace();
            }
        }

        return new ArrayList<>();
    }
}
