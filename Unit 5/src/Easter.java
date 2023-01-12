public class Easter {
    private final int year;
    
    public Easter(int year) {
        this.year = year;
    }

    public String getEasterDate() {
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
        switch(n) {
            case 2 -> result = "February ";
            case 3 -> result = "March ";
            case 4 -> result = "April ";
            case 5 -> result = "May ";
            default -> {
                return "Error!";
            }
        }

        return result + p;
    }
}
