import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * This class calculates the change given to a customer.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 */
public class Cashier {
    /**
     * This method creates a new Cashier object.
     * @param cost The cost of the item.
     * @param amountGiven The amount of money given by the customer.
     * @return A new Cashier object.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Cashier
     */
    public Cashier(double cost, double amountGiven) {
        this.cost = cost;
        this.amountGiven = amountGiven;
    }

    //Starting variables
    private final double cost;
    private final double amountGiven;
    //Doubles that control the price of each coin.
    private final double dollarValue = 1.0;
    private final double quarterValue = 0.25;
    private final double dimeValue = 0.1;
    private final double nickelValue = 0.05;

    /**
     * This method calculates the change given to the customer.
     * @return A list of the amount of each coin given to the customer.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Cashier
     * @throws IllegalArgumentException If the amount given is less than the cost.
     */
    public List<Integer> getChange() {
        List<Integer> change = new ArrayList<>();
        // Calculates the amount of change to be given to the customer. If the amount given is less than the cost, throw an IllegalArgumentException. If the amount given is equal to the cost, return a list of 0s.
        double amountOfChange = amountGiven - cost;
        if (amountOfChange < 0) {
            throw new IllegalArgumentException("Not enough money to cover the cost of the item(s).");
        }
        if (amountOfChange == 0) {
            JOptionPane.showMessageDialog(null, "The customer has given you exact change.");
            change.add(0);
            change.add(0);
            change.add(0);
            change.add(0);
            change.add(0);
            return change;
        }
        // Calculates the amount of each coin to be given to the customer and adds it to the list.
        change.add((int) Math.round(getDollars(amountOfChange).get(0)));
        amountOfChange = getDollars(amountOfChange).get(1);

        change.add((int) Math.round(getQuarters(amountOfChange).get(0)));
        amountOfChange = getQuarters(amountOfChange).get(1);

        change.add((int) Math.round(getDimes(amountOfChange).get(0)));
        amountOfChange = getDimes(amountOfChange).get(1);

        change.add((int) Math.round(getNickels(amountOfChange).get(0)));
        amountOfChange = getNickels(amountOfChange).get(1);

        // Adds pennies and returns the list.
        change.add((int) (amountOfChange * 100));
        return change;
    }
    /**
     * This method calculates the amount of dollars to be given to the customer.
     * @param totalChange The amount of change to be given to the customer.
     * @return A list of the amount of dollars and the amount of change left to be given to the customer.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Cashier
     */
    public List<Double> getDollars(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) totalChange;
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * this.dollarValue) * 100.0) / 100.0);
        return dollarChange;
    }

    /**
     * This method calculates the amount of quarters to be given to the customer.
     *  @param totalChange The amount of change to be given to the customer.
     * @return A list of the amount of quarters and the amount of change left to be given to the customer.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Cashier
     */
    public List<Double> getQuarters(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfQuarters = (int) (totalChange / 0.25);
        dollarChange.add((double) numberOfQuarters);
        dollarChange.add(Math.round((totalChange - numberOfQuarters * this.quarterValue) * 100.0) / 100.0);
        return dollarChange;
    }

    /**
     * This method calculates the amount of dimes to be given to the customer.
     * @param totalChange The amount of change to be given to the customer.
     * @return A list of the amount of dimes and the amount of change left to be given to the customer.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Cashier
     */
    public List<Double> getDimes(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) (totalChange / 0.1);
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * this.dimeValue) * 100.0) / 100.0);
        return dollarChange;
    }

    /**
     * This method calculates the amount of nickels to be given to the customer.
     * @param totalChange The amount of change to be given to the customer.
     * @return A list of the amount of nickels and the amount of change left to be given to the customer.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Cashier
     */
    public List<Double> getNickels(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) (totalChange / 0.05);
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * this.nickelValue) * 100.0) / 100.0);
        return dollarChange;
    }
}
