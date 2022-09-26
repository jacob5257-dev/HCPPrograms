import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Grade: ");
        String user_grade = myObj.nextLine();

        int grade;
        try {
            grade = Integer.parseInt(user_grade);
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid grade!");
        }

        if (grade >= 90) System.out.println("Your grade is an A.");
        if (grade >= 80) System.out.println("Your grade is a B.");
        if (grade >= 70) System.out.println("Your grade is an C.");
        if (grade >= 60) System.out.println("Your grade is an D.");
        else System.out.println("Your grade is an F.");
    }
}
