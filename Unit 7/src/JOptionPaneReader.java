import javax.swing.JOptionPane;
public class JOptionPaneReader {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        String ageStr = JOptionPane.showInputDialog("How old are you?");
        String moneyStr = JOptionPane.showInputDialog("How much money do you have?");
        int age = 0;
        double money = 0;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 1) throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, ageStr + " is an invalid age!");
            System.exit(1);
        }
        try {
            money = Double.parseDouble(moneyStr);
            if (money < 0) throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, moneyStr + " is an invalid amount of money!");
            System.exit(1);
        }
        JOptionPane.showMessageDialog(null, name + " is " + age + " years old and has $" + money + "!");
    }
}
