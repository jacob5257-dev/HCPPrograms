import javax.swing.*;

public class SammysRentalPrice {
    public static void main(String[] args) {
        /*
        Sammy’s Seashore Supplies rents beach equipment such as kayaks, canoes, beach chairs, and umbrellas to tourists.  Write a program that prompts the user for the number of minutes they rented the piece of sports equipment.  Compute the rental cost as $40 per hour plus $1 for each additional minute.  (You might have surmised already this rate has a logical flaw, but for now, calculate rates as described here.  You can fix the problem after we learn decision-making.)  Display Sammy’s motto “Sammy’s makes it fun in the sun” surrounded by a border composed of repeated “Ss.”  Save the file as SammysRentalPrice.java
         */
        String input = JOptionPane.showInputDialog("How many minutes did you rent the equipment for?");
        int minutes = Integer.parseInt(input);
        int hours = minutes / 60;
        int minutesLeft = minutes % 60;
        int price = (hours * 40) + minutesLeft;
        JOptionPane.showMessageDialog(null, "You rented the equipment for " + hours + " hours and " + minutesLeft + " minutes.  The total price is $" + price + ".\n\n" + "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs\nSs Sammy’s makes it fun in the sun Ss\nSsSsSsSsSsSsSsSsSsSsSsSsSsSsSs");

    }
}
