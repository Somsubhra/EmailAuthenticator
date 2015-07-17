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
     * The IMAP Server Host
     */
    private String imapHost;

    /**
     * The IMAP Server Port
     */
    private int imapPort;
    /**
     * Use SSL for the connection or not
     */
    private boolean useSSL;

    /**
     * The User's email address
     */
    private String emailAddress;

    /**
     * The User's password
     */
    private String password;

    /**
     * Constructor for the Authenticator
     */
    public Authenticator(String imapHost, int imapPort, boolean useSSL, String emailAddress, String password) {
        this.imapHost = imapHost;
        this.imapPort = imapPort;
        this.useSSL = useSSL;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    /**
     * The Builder class
     */
    public static class Builder {
        private String imapHost;
        private int imapPort;
        private boolean useSSL;
        private String emailAddress;
        private String password;

        public Builder(String imapHost) {
            this.imapHost = imapHost;
        }

        public Builder port(int imapPort) {
            this.imapPort = imapPort;
            return this;
        }

        public Builder ssl(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        public Builder email(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Authenticator build() {
            return new Authenticator(this);
        }
    }

    /**
     * Constructor for the authenticator
     */
    private Authenticator(Builder builder) {
        this.imapHost = builder.imapHost;
        this.imapPort = builder.imapPort;
        this.useSSL = builder.useSSL;
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
    }

    /**
     * Authenticate a given email and password
     */
    public boolean authenticate() {

        Properties props = System.getProperties();

        String sslStr = "false";

        if(this.useSSL) {
            sslStr = "true";
        }

        props.put("mail.imaps.auth.plain.disable", sslStr);

        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(this.imapHost, this.imapPort, this.emailAddress, this.password);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
