/**
 * This class calculates the date of Easter for a given year.
 * @since 2023-01-18
 * @version 1.0
 * @author jacob5257
 * @see Easter
 */

public class Easter {
    // The year to calculate Easter for.
    private final int year;
    
    /**
     * This constructor creates an Easter object.
     * @param year The year to calculate the date of Easter for.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Easter
     */
    public Easter(int year) {
        this.year = year;
    }

    /**
     * This method calculates the date of Easter for the given year.
     * @return The date of Easter for the given year.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Easter
     */
    public String getEasterDate() {
        //Sets up variables and solves for the date of Easter.
        String result;
        int a = year % 19,
            b = year / 100,
            c = year % 100,
            d = b / 4,
            e = b % 4,
            g = (8 * b + 13) / 25,
            h = (19 * a + b - d - g + 15) % 30,
            j = c / 4,
            k = c % 4,
            m = (a + 11 * h) / 319,
            r = (2 * e + 2 * j - k - h + m + 32) % 7,
            n = (h - m + r + 90) / 25,
            p = (h - m + r + n + 19) % 32;
        // Adds the month and day to the result.
        switch(n) {
            case 2 -> result = "February ";
            case 3 -> result = "March ";
            case 4 -> result = "April ";
            case 5 -> result = "May ";
            default -> {
                return "Error!";
            }
        }
        // Returns the result.
        return result + p;
    }
}
