/**
 * The Main application class
 */

public class Runner {

    public static void main(String[] args) {
        Authenticator a = new Authenticator.Builder("imap-mail.outlook.com").port(993).ssl(true).email("somsubhra.bairi@outlook.com").password("%1216725som%").build();
        System.out.println(a.authenticate());
    }
}
