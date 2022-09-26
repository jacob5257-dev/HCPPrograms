import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter 1 to validate, 2 to generate: ");
        String optionInput = myScanner.nextLine();
        System.out.println(optionInput);
        if (Objects.equals(optionInput, "1")) {
            System.out.print("Enter CC#: ");
            String ccInput = myScanner.nextLine();
            Main.validate(ccInput);
        }
        else if (Objects.equals(optionInput, "2")) {


            System.out.println("WIP");
        }
        else System.out.println("Invalid option!");
    }

    public static String generateMastercard() {
        //51-55

        return "WIP";
    }

    public static String generateVisa() {
        return "WIP";
    }

    public static int generateRandomNumbers(int numOfNum) {
        for (int i = 0; i < numOfNum; i++) {

        }




        return 0;
    }
}
