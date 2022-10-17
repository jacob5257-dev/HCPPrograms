import javax.swing.*;

public class SammysRentalButFixed {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("How many minutes did you rent the equipment for?");
        int minutes = Integer.parseInt(input);
        int hours = minutes / 60;
        int minutesLeft = minutes % 60;
        if (minutesLeft > 40) {
            hours++;
            minutesLeft = 0;
        }
        int price = (hours * 40) + minutesLeft;
        JOptionPane.showMessageDialog(null, "You rented the equipment for " + hours + " hours and " + minutesLeft + " minutes.  The total price is $" + price + ".\n\n" + "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs\nSs Sammy’s makes it fun in the sun Ss\nSsSsSsSsSsSsSsSsSsSsSsSsSsSsSs");
    }
}
