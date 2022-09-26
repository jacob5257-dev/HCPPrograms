import java.util.ArrayList;
import java.util.List;

public class Cashier {
    static double dollarValue = 1.0;
    static double quarterValue = 0.25;
    static double dimeValue = 0.1;
    static double nickelValue = 0.05;

    public static List<Integer> getChange(double cost, double amountGiven) {
        List<Integer> change = new ArrayList<>();
        double amountOfChange = amountGiven - cost;
        if (amountOfChange < 0) {
            System.out.println("The customer hasn't given you enough money to complete the transaction.");
            return change;
        }
        if (amountOfChange == 0) {
            System.out.println("The customer has given you exact change.");
            change.add(0);
            change.add(0);
            change.add(0);
            change.add(0);
            change.add(0);
            return change;
        }

        change.add((int) Math.round(getDollars(amountOfChange).get(0)));
        amountOfChange = getDollars(amountOfChange).get(1);

        change.add((int) Math.round(getQuarters(amountOfChange).get(0)));
        amountOfChange = getQuarters(amountOfChange).get(1);

        change.add((int) Math.round(getDimes(amountOfChange).get(0)));
        amountOfChange = getDimes(amountOfChange).get(1);

        change.add((int) Math.round(getNickels(amountOfChange).get(0)));
        amountOfChange = getNickels(amountOfChange).get(1);

        change.add((int) (amountOfChange * 100));
        return change;
    }
    public static List<Double> getDollars(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) totalChange;
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * dollarValue) * 100.0) / 100.0);
        return dollarChange;
    }
    public static List<Double> getQuarters(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfQuarters = (int) (totalChange / 0.25);
        dollarChange.add((double) numberOfQuarters);
        dollarChange.add(Math.round((totalChange - numberOfQuarters * quarterValue) * 100.0) / 100.0);
        return dollarChange;
    }
    public static List<Double> getDimes(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) (totalChange / 0.1);
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * dimeValue) * 100.0) / 100.0);
        return dollarChange;
    }
    public static List<Double> getNickels(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) (totalChange / 0.05);
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * nickelValue) * 100.0) / 100.0);
        return dollarChange;
    }
}
