import javax.swing.*;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class LoginVerification {
    public static void main(String[] args) {
        Hashtable<String, String> logins = LoginVerificationManager.getLogins();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the login verification system!");
        System.out.print("Enter admin password or blank to skip: ");
        String adminPassword = scanner.nextLine();
        if (Objects.equals(adminPassword, "admin")) {
            while (true) {
                String option = JOptionPane.showInputDialog("Enter option (add, remove, clear, or exit):");
                if (Objects.equals(option, "add")) {
                    String username = JOptionPane.showInputDialog("Enter username:");
                    String password = JOptionPane.showInputDialog("Enter password:");
                    LoginVerificationManager.addLogin(username, password);
                }
                else if (Objects.equals(option, "remove")) {
                    String username = JOptionPane.showInputDialog("Enter username:");
                    boolean success = LoginVerificationManager.removeLogin(username);
                    if (success) JOptionPane.showMessageDialog(null, "Successfully removed login.");
                    else JOptionPane.showMessageDialog(null, "Failed to remove login.");
                }
                else if (Objects.equals(option, "clear")) LoginVerificationManager.clearLogins();
                else if (Objects.equals(option, "exit")) break;
                else JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }

        int attempts = 1;

        while (true) {
            if (attempts > 3) {
                System.out.println("You have used the maximum login attempts! Please contact technical support at help@jacob5257.com.");
                break;
            }

            Scanner myObj = new Scanner(System.in);
            System.out.print("Username: ");
            String username = myObj.nextLine();
            System.out.print("Password: ");
            String password = myObj.nextLine();

            if (Objects.equals(logins.get(username), password)) {
                System.out.println("Login successful!");
                myObj.close();
                break;
            }
            else {
                System.out.println("Incorrect username or password!");
                myObj.close();
                attempts++;
            }
        }
        scanner.close();
    }
}
