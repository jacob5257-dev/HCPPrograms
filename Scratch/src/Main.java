import java.awt.*;
import javax.swing.*;

public class Main {
    private static void createAndShowUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );

        //  Build a custom panel

        JPanel panel = new JPanel( new GridLayout(2, 2) );
        panel.add( new JLabel("First Name") );
        JTextField firstName = new JTextField(10);
//      firstName.addAncestorListener( new RequestFocusListener(false) );
        panel.add( firstName );
        panel.add( new JLabel("Last Name") );
        JTextField lastName = new JTextField(10);
        panel.add( lastName );

        int result = JOptionPane.showConfirmDialog(
            frame, // use your JFrame here
            panel,
            "Use a Panel",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        if(result == JOptionPane.YES_OPTION)
        {
            System.out.println(firstName.getText() + " : " + lastName.getText());
        }
        else
        {
            System.out.println("Canceled");
        }

        //  Let Option Pane build the panel for you

        Object[] msg = {"First Name:", firstName, "Last Name:", lastName};

        result = JOptionPane.showConfirmDialog(
            frame,
            msg,
            "Use default layout",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.YES_OPTION)
        {
            System.out.println(firstName.getText() + " : " + lastName.getText());
        }
        else
        {
            System.out.println("Canceled");
        }
    }

    public static void main(String[] args)
    {
        createAndShowUI();
    }


}