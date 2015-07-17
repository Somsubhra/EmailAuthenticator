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
            Authenticator a = new Authenticator.Builder(record.getImapHost())
                    .port(record.getImapPort())
                    .ssl(record.getUseSSL())
                    .email(record.getEmail())
                    .password(record.getPassword())
                    .build();

            if(a.authenticate()) {
                legalRecords.add(record);
            } else {
                illegalRecords.add(record);
            }
        }

        CSVWriter.writeCSV("legal_records.csv", legalRecords);
        CSVWriter.writeCSV("illegal_records.csv", illegalRecords);
    }
}
