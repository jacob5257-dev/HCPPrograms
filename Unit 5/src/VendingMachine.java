/**
 * A vending machine that accepts coins and dispenses cans of soda.
 * The price of a can is set when the machine is constructed.
 * The machine keeps track of the number of cans it contains.
 * The machine keeps track of the total amount of money it has received.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see VendingMachineTest
 */

public class VendingMachine {
    // Instance variables
    private int cans;
    private double money;
    private final double price;
    private double moneyInserted;

    /**
     * Constructs a VendingMachine object.
     * @param price the price of a can of soda in this machine
     */
    public VendingMachine(double price) {
        this.price = price;
    }

    /**
     * Gets the number of cans in the machine.
     * @return the number of cans in the machine
     */
    public int getCanCount() {
        return cans;
    }

    /**
     * Fills the machine with the specified number of cans.
     * @param cans the number of cans to add to the machine
     */
    public void fillUp(int cans) {
        this.cans = cans;
    }

    /**
     * Inserts a coin into the machine.
     * If the total money inserted is greater than or equal to the price of a can, then the machine dispenses a can and returns the change.
     * @param coin the coin to insert into the machine
     */
    public void insertCoin(double coin) {
        moneyInserted += coin;
        if (moneyInserted >= price) {
            cans--;
            money += price;
            moneyInserted = 0;
        }
    }

    /**
     * Gets the total amount of money in the machine.
     * @return the total amount of money in the machine
     */
    public double getBankBalance() {
        return money;
    }
}
