/*
This code allows you to add coins to a virtual piggy bank.
Note you must add variables in pennies_in_bank, nickels_in_bank, etc.
 */

//Some imports for equality testing and inputs
import java.util.Objects;
import java.util.Scanner;

public class piggybank {
    public static void main(String[] args) {
        //ADD! Set these as how many you have in the bank.
        final int pennies_in_bank = 0;
        final int nickels_in_bank = 0;
        final int dimes_in_bank = 0;
        final int quarters_in_bank = 4;

        //Initiating variables for inputs
        int pennies = 0;
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        String pennies_str;
        String nickels_str;
        String dimes_str;
        String quarters_str;
        String input;

        //Keeps going until user stops it.
        while (true) {
            //Asks if there are coins to add and takes input.
            Scanner myObj = new Scanner(System.in);
            System.out.println("Do you have coins to add? ");
            input = myObj.nextLine();

            //If it's not blank or "no", code runs.
            if (!Objects.equals(input, "")  && !Objects.equals(input.toLowerCase(), "no")) {
                System.out.println("How many pennies? ");
                pennies_str = myObj.nextLine();
                System.out.println("How many nickels? ");
                nickels_str = myObj.nextLine();
                System.out.println("How many dimes? ");
                dimes_str = myObj.nextLine();
                System.out.println("How many quarters? ");
                quarters_str = myObj.nextLine();
                //Checks if user left any input blank and throws error.
                if (Objects.equals(pennies_str, "") || Objects.equals(nickels_str, "") || Objects.equals(dimes_str, "") || Objects.equals(quarters_str, "")) {
                    throw new RuntimeException("ERROR: Empty value.");
                }
                //Adds user input to total added for round.
                pennies += Integer.parseInt(pennies_str);
                nickels += Integer.parseInt(nickels_str);
                dimes += Integer.parseInt(dimes_str);
                quarters += Integer.parseInt(quarters_str);
            }
            //Otherwise stop
            else break;
        }

        //Prints how much the user put inside their bank in this round.
        System.out.println("You have added " + pennies + " pennies, " + nickels + " nickels, " + dimes + " dimes, and " + quarters + " quarters.");
        //Prints total coins.
        System.out.println("You now have " + (pennies_in_bank + pennies) + " pennies, " + (nickels_in_bank + nickels) + " nickels, " + (dimes + dimes_in_bank) + " dimes, and " + (quarters_in_bank + quarters) + " quarters.");
        //Prints total balance.
        System.out.println("Your total balance is now $" + Math.round((0.01 * pennies + 0.01 * pennies_in_bank + 0.05 * nickels + 0.05 * nickels_in_bank + 0.1 * dimes + 0.1 * dimes_in_bank + 0.25 * quarters + 0.25 * quarters_in_bank) * 100.0) / 100.0);
    }
}