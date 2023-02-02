import java.util.Scanner;

public class CountByAnything {
    public static void main(String[] args) {
        String output = "";
        Scanner myObj = new Scanner(System.in);
        System.out.println("Count by how much? ");
        int iteration = Integer.parseInt(myObj.nextLine());
        int times = 0;

        for (int i = iteration; i <= 500; i += iteration) {
            output += i + " ";
            times++;
            if (times == 10) {
                System.out.println(output);
                output = "";
                times = 0;
            }
        }
        myObj.close();
    }
}
