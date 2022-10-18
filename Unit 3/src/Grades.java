import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Grade: ");
        String user_grade = myObj.nextLine();
        String letter_grade = "F";

        int grade;
        try {
            grade = (int) Double.parseDouble(user_grade);
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid grade!");
        }

        if (grade >= 90) letter_grade = "A";
        else if (grade >= 80) letter_grade = "B";
        else if (grade >= 70) letter_grade = "C";
        else if (grade >= 60) letter_grade = "D";

        System.out.println("Letter grade: " + letter_grade);
    }
}
