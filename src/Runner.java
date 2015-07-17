import java.util.ArrayList;

/**
 * The Main application class
 */

public class Runner {

    public static void main(String[] args) {
        ArrayList<Record> records = CSVReader.readCSV("records.csv");

        ArrayList<Record> illegalRecords = new ArrayList<>();
        ArrayList<Record> legalRecords = new ArrayList<>();

        for(Record record : records) {
            if(Authenticator.authenticate(record)) {
                legalRecords.add(record);
            } else {
                illegalRecords.add(record);
            }
        }

        CSVWriter.writeCSV("legal_records.csv", legalRecords);
        CSVWriter.writeCSV("illegal_records.csv", illegalRecords);
    }
}
