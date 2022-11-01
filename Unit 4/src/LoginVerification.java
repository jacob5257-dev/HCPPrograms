import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class LoginVerification {
    public static void main(String[] args) {
        Hashtable<String, String> logins = new Hashtable<>();
        logins.put("username", "password");

        int attempts = 1;

        while (true) {
            if (attempts > 3) {
                System.out.println("You have used the maximum login attempts! Please contact technical support at help@jacob5257.com.");
                break;
            }

            Scanner myObj = new Scanner(System.in);
            System.out.println("Username: ");
            String username = myObj.nextLine();
            System.out.println("Password: ");
            String password = myObj.nextLine();

            if (Objects.equals(logins.get(username), password)) {
                System.out.println("Login successful!");
                break;
            }
            else {
                System.out.println("Incorrect username or password!");
                attempts++;
            }
        }
    }
}
