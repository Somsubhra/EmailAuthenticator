/**
 * The Record POJO
 */
public class Record {

    /**
     * IMAP Host
     */
    private String imapHost;

    /**
     * IMAP port
     */
    private int imapPort;

    /**
     * Use SSL for IMAP connection or not
     */
    private boolean useSSL;

    /**
     * Email address
     */
    private String email;

    /**
     * Password for email
     */
    private String password;

    /**
     * Constructor for Record POJO
     */
    public Record(String imapHost, int imapPort, boolean useSSL, String email, String password) {
        this.imapHost = imapHost;
        this.imapPort = imapPort;
        this.useSSL = useSSL;
        this.email = email;
        this.password = password;
    }

    /**
     * Getter methods
     */
    public String getImapHost() {
        return this.imapHost;
    }

    public int getImapPort() {
        return this.imapPort;
    }

    public boolean getUseSSL() {
        return this.useSSL;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    /**
     * End of getter methods
     */

    /**
     * The Builder class
     */
    public static class Builder {
        private String imapHost;
        private int imapPort;
        private boolean useSSL;
        private String email;
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

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }

    /**
     * Constructor for the Record
     */
    private Record(Builder builder) {
        this.imapHost = builder.imapHost;
        this.imapPort = builder.imapPort;
        this.useSSL = builder.useSSL;
        this.email = builder.email;
        this.password = builder.password;
    }
}
