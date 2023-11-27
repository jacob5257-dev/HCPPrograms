import java.util.Hashtable;

public class LoginVerificationManager {
    static final Hashtable<String, String> logins = new Hashtable<>();
    // skipcq: JAVA-W1065
    public static Hashtable<String, String> getLogins() { return logins; }
    public static void addLogin(String username, String password) { logins.put(username, password); }
    public static boolean removeLogin(String username) {
        if (logins.contains(username)) {
            logins.remove(username);
            return true;
        }
        else return false;
    }
    public static void clearLogins() { logins.clear(); }
}
