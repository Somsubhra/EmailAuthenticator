/**
 * All Imports
 */
import java.util.Properties;
import javax.mail.*;

/**
 * Authenticate a given email address and password
 * through IMAP.
 */
public class Authenticator {

    /**
     * Authenticate a given email and password
     */
    public static boolean authenticate(Record record) {

        Properties props = System.getProperties();

        try {
            Session session = Session.getDefaultInstance(props, null);

            String storeType = record.getUseSSL() ? "imaps" : "imap";
            Store store = session.getStore(storeType);

            store.connect(record.getImapHost(), record.getImapPort(), record.getEmail(), record.getPassword());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
