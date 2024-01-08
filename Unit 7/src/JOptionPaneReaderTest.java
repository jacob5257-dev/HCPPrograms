import javax.swing.*;
//skipcq: JAVA-W1088
public class JOptionPaneReaderTest {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        while (true) {
            if (name == null) {
                JOptionPane.showMessageDialog(null, "You must enter a name!");
                name = JOptionPane.showInputDialog("What is your name?");
            }
            else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter a name!");
                name = JOptionPane.showInputDialog("What is your name?");
            }
            else {
                break;
            }
        }
        String ageStr;
        int age;
        while (true) {
            ageStr = JOptionPane.showInputDialog("How old are you?");
            if (ageStr == null) {
                JOptionPane.showMessageDialog(null, "You must enter an age!");
                name = JOptionPane.showInputDialog("What is your name?");
            }
            else if (ageStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter an age!");
                name = JOptionPane.showInputDialog("What is your name?");
            }
            else {
                try {
                    age = JOptionPaneReader.readInt(ageStr);
                    if (age < 0 || age > 100) {
                        throw new NumberFormatException();
                    }
                    break;
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, ageStr + " is an invalid age!");
                }
            }
        }
        String moneyStr;
        double money;
        while (true) {
            moneyStr = JOptionPane.showInputDialog("How much money do you have?");
            if (moneyStr == null) {
                JOptionPane.showMessageDialog(null, "You must enter an amount of money!");
                name = JOptionPane.showInputDialog("What is your name?");
            }
            else if (moneyStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter an amount of money!");
                name = JOptionPane.showInputDialog("What is your name?");
            }
            else {
                try {
                    money = JOptionPaneReader.readDouble(moneyStr);
                    if (money < 0) {
                        throw new NumberFormatException();
                    }
                    break;
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, moneyStr + " is an invalid amount of money!");
                }
            }
        }
        JOptionPane.showMessageDialog(null, name + " is " + age + " years old and has $" + money + "!");
    }
}
