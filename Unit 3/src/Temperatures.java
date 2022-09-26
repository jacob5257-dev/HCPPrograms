import java.util.Scanner;

public class Temperatures {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("High: ");
        String user_high = myObj.nextLine();
        System.out.println("Low: ");
        String user_low = myObj.nextLine();

        int high_temp;
        int low_temp;
        try {
            high_temp = Integer.parseInt(user_high);
            low_temp = Integer.parseInt(user_low);
        } catch (Exception e) {
            throw new RuntimeException("Invalid temperature.");
        }

        if (high_temp >= 90) System.out.println("Heat warning!");
        if (low_temp <= 32) System.out.println("Freeze warning!");
        if (high_temp - low_temp > 40) System.out.println("Large temperature swing!");
    }
}
