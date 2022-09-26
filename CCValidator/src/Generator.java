import java.util.*;

public class Generator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter 1 to validate, 2 to generate: ");
        String optionInput = myScanner.nextLine();
        if (Objects.equals(optionInput, "1")) {
            System.out.print("Enter CC#: ");
            String ccInput = myScanner.nextLine();
            Main.validate(ccInput, true);
        }
        else if (Objects.equals(optionInput, "2")) {
            System.out.print("How many numbers to generate? ");
            optionInput = myScanner.nextLine();
            int count = 1;

            try { count = Integer.parseInt(optionInput); }
            catch (Exception e) { System.out.println("Invalid option, going with 1..."); }
            if (count == 0) System.out.println("Done!");
            if (count < 0) System.out.println("Negative number, going with infinity...");

            while (count != 0) {
                String ccNumber = generateVisa();
                if (Main.validate(ccNumber, false)) {
                    System.out.println(ccNumber);
                    count--;
                }
            }
        }
        else System.out.println("Invalid option!");
    }

    public static String generateVisa() {
        return "4" + generateRandomNumbers(15);
    }

    public static String generateRandomNumbers(int numOfNum) {
        String numbers = "";
        for (int i = 0; i < numOfNum; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            numbers += String.valueOf(randomNumber);
        }

        return numbers;
    }
}
