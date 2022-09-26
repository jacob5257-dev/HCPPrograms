import java.util.*;

public class Generator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter 1 to validate, 2 to generate: ");
        String optionInput = myScanner.nextLine();
        if (Objects.equals(optionInput, "1")) {
            System.out.print("Enter CC#: ");
            String ccInput = myScanner.nextLine();
            Main.validate(ccInput);
        }
        else if (Objects.equals(optionInput, "2")) {
            while (true) {
                String ccNumber = generateVisa();
                if (Main.validate(ccNumber)) {
                    System.out.println(ccNumber);
                    break;
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
