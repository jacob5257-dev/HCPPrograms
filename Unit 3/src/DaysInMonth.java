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
        if (month_number == 1 || month_number == 3 || month_number == 5 || month_number == 7 || month_number == 8 || month_number == 10 || month_number == 12) System.out.println("31 days");
        else if (month_number == 4 || month_number == 6 || month_number == 9 || month_number == 11) System.out.println("30 days");
        else if (month_number == 2) System.out.println("28 days");
        else throw new RuntimeException("Invalid month!");
    }
}
