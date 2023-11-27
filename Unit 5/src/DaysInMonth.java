/**
 * Implement a class DaysInMonth that has a constructor that takes the number of the month as a parameter (1 for January, 2 for February, and so on) and has a method getDays that returns the number of days in that month. For example, the call new DaysInMonth(2).getDays() should return 28. Assume that the constructor is passed a valid month number. Also assume that the year is not a leap year.
 * @author jacob5257
 * @since 2023-02-14
 * @version 1.0
 */

public class DaysInMonth {
    // Instance variable that holds the month number.
    private final int month;

    /**
     * Constructor that takes the number of the month as a parameter (1 for January, 2 for February, and so on)
     * @param month The month number
     */
    public DaysInMonth(int month) {
        this.month = month;
    }

    /**
     * Returns the number of days in that month.
     * @return The number of days in that month.
     */
    public int getDays() {
        // If the month is January, March, May, July, August, October, or December, return 31.
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) return 31;
        // If the month is April, June, September, or November, return 30.
        else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        // If the month is February, return 28.
        else if (month == 2) return 28;
        // If the month is not a valid month, return -1.
        else return -1;
    }
}
