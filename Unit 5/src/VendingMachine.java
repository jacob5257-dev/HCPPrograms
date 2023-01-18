/**
 * A vending machine that accepts coins and dispenses cans of soda.
 * The price of a can is set when the machine is constructed.
 * The machine keeps track of the number of cans it contains.
 * The machine keeps track of the total amount of money it has received.
 * The machine dispenses a can only if it has been filled and enough money has been inserted.
 * The machine returns change if too much money has been inserted.
 * The machine does not dispense a can if it has not been filled.
 * The machine does not dispense a can if not enough money has been inserted.
 * The machine does not dispense a can if too much money has been inserted.
 * The machine does not dispense a can if it has been filled and enough money has been inserted, but the can has already been dispensed.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see VendingMachineTest
 */

public class VendingMachine {
    private int cans;
    private double money;
    private double price;
    private double moneyInserted;

    public VendingMachine(double price) {
        this.price = price;
    }

    public int getCanCount() {
        return cans;
    }

    public void fillUp(int cans) {
        this.cans = cans;
    }

    public void insertCoin(double coin) {
        moneyInserted += coin;
        if (moneyInserted >= price) {
            cans--;
            money += price;
            moneyInserted = 0;
        }
    }

    public double getBankBalance() {
        return money;
    }
}
