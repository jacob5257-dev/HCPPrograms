import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Month number: ");
        String month = myObj.nextLine();
        int month_number;
        try {
            month_number = Integer.parseInt(month);
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid month!");
        }
        int month_even = 0;
        if (month_number == 2) { month_even = 2; }
        else if (month_number < 1 || month_number > 12) { System.out.println("Not a month!"); }
        else {
            if (month_number % 2 == 0) month_even = 1;
            else if (month_number % 2 == 1) month_even = 0;

            switch (month_even) {
                case 0 -> System.out.println("The month has 31 days.");
                case 1 -> System.out.println("The month has 30 days.");
                case 2 -> System.out.println("This month has 28 days.");
            }
        }
    }
}
