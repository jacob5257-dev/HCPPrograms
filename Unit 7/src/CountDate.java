// Import for JOptionPane
import javax.swing.*;

/**
 * This program will convert mm/dd/yyyy to MMMM dd, yyyy and give the day of the year.
 * @since 7/31/2023
 * @version 1.0
 * @author jacob5257
 */
public class CountDate {
    public static void main(String[] args) {
        // Ask the user for a date in the format mm/dd/yyyy
        String input = JOptionPane.showInputDialog("Enter a date in the format mm/dd/yyyy");
        // Creates lists for the months and number of days in each month.
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                           "October", "November", "December"};
        // 29 is necessary so leap years don't fail the day out of bounds for month check
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30,
                             31, 30, 31};
        // Creates variables for the month, day, year, and day of the year.
        int month = 0;
        int day = 0;
        int year = 0;
        int days = 0;
        try {
            // Parses month by finding numbers between the beginning and the first "/", day by finding the characters between the two "/"'s, and the year by the characters
            // between the last "/" and the end. If there aren't enough slashes, or they aren't integers, they are caught by the try/catch.
            month = Integer.parseInt(input.substring(0, input.indexOf('/')));
            day = Integer.parseInt(input.substring(input.indexOf('/') + 1, input.lastIndexOf("/")));
            year = Integer.parseInt(input.substring(input.lastIndexOf("/") + 1));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid date: improper format.");
            System.exit(0);
        }
        // If the month is less than 1 or greater than 12, it is not a month.
        if (month < 1 || month > 12) {
            JOptionPane.showMessageDialog(null, "Invalid date: not a month.");
            System.exit(0);
        }
        // Checks if the date exists in the month and if it should accept Feb. 29 based on isNotLeapYear().
        if ((day < 1 || day > daysInMonth[month - 1]) || (month == 2 && day == 29 && isNotLeapYear(year))) {
            JOptionPane.showMessageDialog(null, "Invalid date: not a day.");
            System.exit(0);
        }
        // Adds the days in the months before the month inputted.
        for (int i = 0; i < month - 1; i++) {
            days += daysInMonth[i];
        }
        // Adds the day to the total day counter.
        days += day;
        // If it isn't a leap year and the month is after February, remove the 29th since the list has February as having 29 days.
        if (isNotLeapYear(year) && month > 2) days--;
        // Print out all the info
        JOptionPane.showMessageDialog(null, "The day is " + months[month - 1] + " " + day + ", " + year + ".\nIt is day " + days + " of the year.");
    }

    public static boolean isNotLeapYear(int year) {
        if (year % 4 != 0) return true;
        if (year % 400 == 0) return false;
        return year % 100 == 0;
    }
}
