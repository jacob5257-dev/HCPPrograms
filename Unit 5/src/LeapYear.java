public class LeapYear {
    private int year;

    public LeapYear(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public String toString() {
        if (year >= 1852) return "The year " + year + " is " + (isLeapYear() ? "" : "not ") + "a leap year.";
        else return "The year " + year + " is " + (year % 4 == 0 ? "": "not ") + "a leap year.";
    }
}
