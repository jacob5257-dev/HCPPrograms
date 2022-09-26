import java.util.Scanner;

public class name {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What's your name? ");

        String userName = myObj.nextLine();  // Read user input
        int nameLength = userName.length();
        String dashes = "";
        for (int i = 0; i < nameLength; i++) {
            dashes += "-";
        }
        HelloWorld.print("+--" + dashes + "--+");
        HelloWorld.print("|  " + userName + "  |");
        HelloWorld.print("+--" + dashes + "--+");
    }
}
