/**
 * A class that determines if a year is a leap year.
 * @author jacob5257
 * @since 2023-02-14
 * @version 1.0
 */
public class LeapYear {
    // Instance variable that holds the year.
    private final int year;

    /**
     * Constructor that takes the year as a parameter.
     * @param year The year.
     */
    public LeapYear(int year) {
        this.year = year;
    }

    /**
     * Returns true if the year is a leap year, false otherwise.
     * @return True if the year is a leap year, false otherwise.
     */
    public boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Returns a string representation of the object.
     * @return A string representation of the object.
     */
    public String toString() {
        // If the year is after 1852, use the Gregorian calendar.
        if (year >= 1852) return "The year " + year + " is " + (isLeapYear() ? "" : "not ") + "a leap year.";
        else return "The year " + year + " is " + (year % 4 == 0 ? "": "not ") + "a leap year.";
    }
}
