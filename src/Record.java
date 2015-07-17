/**
 * The Record POJO
 */
public class Record {

    private String imapHost;
    private int imapPort;
    private boolean useSSL;
    private String email;
    private String password;

    public Record(String imapHost, int imapPort, boolean useSSL, String email, String password) {
        this.imapHost = imapHost;
        this.imapPort = imapPort;
        this.useSSL = useSSL;
        this.email = email;
        this.password = password;
    }

    public void setImapHost(String imapHost) {
        this.imapHost = imapHost;
    }

    public String getImapHost() {
        return this.imapHost;
    }

    public void setImapPort(int imapPort) {
        this.imapPort = imapPort;
    }

    public int getImapPort() {
        return this.imapPort;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public boolean getUseSSL() {
        return this.useSSL;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return this.imapHost + "," +
                this.imapPort + "," +
                this.useSSL + "," +
                this.email + "," +
                this.password + "\n";
    }
}
