import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in);
            System.out.print("Cost of items: $");
            double cost = myObj.nextDouble();
            System.out.print("Amount given: $");
            double amountGiven = myObj.nextDouble();

            List<Integer> change = Cashier.getChange(cost, amountGiven);
            System.out.println("You need to give the customer " + change.get(0) + " dollars, " + change.get(1) + " quarters, " + change.get(2) + " dimes, " + change.get(3) + " nickels, and " + change.get(4) + " pennies.");
        }
        catch (Exception e) {
            throw new RuntimeException("Are you sure those are valid numbers?");
        }
    }
}