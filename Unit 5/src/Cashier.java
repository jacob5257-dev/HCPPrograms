import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cashier {
    public Cashier(double cost, double amountGiven) {
        this.cost = cost;
        this.amountGiven = amountGiven;
    }

    private double cost;
    private double amountGiven;

    private double dollarValue = 1.0;
    private double quarterValue = 0.25;
    private double dimeValue = 0.1;
    private double nickelValue = 0.05;

    public List<Integer> getChange() {
        List<Integer> change = new ArrayList<>();
        double amountOfChange = amountGiven - cost;
        if (amountOfChange < 0) {
            JOptionPane.showMessageDialog(null, "The customer hasn't given you enough money to complete the transaction.");
            return change;
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

    public List<Double> getDollars(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) totalChange;
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * this.dollarValue) * 100.0) / 100.0);
        return dollarChange;
    }
    public List<Double> getQuarters(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfQuarters = (int) (totalChange / 0.25);
        dollarChange.add((double) numberOfQuarters);
        dollarChange.add(Math.round((totalChange - numberOfQuarters * this.quarterValue) * 100.0) / 100.0);
        return dollarChange;
    }
    public List<Double> getDimes(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) (totalChange / 0.1);
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * this.dimeValue) * 100.0) / 100.0);
        return dollarChange;
    }
    public List<Double> getNickels(double totalChange) {
        List<Double> dollarChange = new ArrayList<>();
        int numberOfDollars = (int) (totalChange / 0.05);
        dollarChange.add((double) numberOfDollars);
        dollarChange.add(Math.round((totalChange - numberOfDollars * this.nickelValue) * 100.0) / 100.0);
        return dollarChange;
    }
}
