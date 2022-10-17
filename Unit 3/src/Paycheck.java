import javax.swing.*;

public class Paycheck {
    public static void main(String[] args) {
        // Write your code here
        String name = JOptionPane.showInputDialog("Enter your name.");
        double hours = Double.parseDouble(JOptionPane.showInputDialog("How many hours did you work?"));
        double payRate = Double.parseDouble(JOptionPane.showInputDialog("What is your pay rate?"));
        double grossPay = hours * payRate;

        if (hours < 0) {
            JOptionPane.showMessageDialog(null, "Invalid hours worked.");
            System.exit(0);
        }
        else if (hours > 40) {
            double overtime = hours - 40.0;
            double overtimePay = overtime * (payRate * 1.5);
            grossPay = (40 * payRate) + overtimePay;
        }


        System.out.println("Paycheck for " + name);
        System.out.println("Hours worked: " + hours);
        System.out.println("Pay rate: $" + payRate);
        System.out.println("Gross pay: $" + grossPay);
    }
}
