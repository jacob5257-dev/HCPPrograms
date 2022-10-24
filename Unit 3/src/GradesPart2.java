import java.util.Scanner;

public class GradesPart2 {
    public static void main(String[] args) {
        /*
        A+ = 97-100
        A = 93-96
        A- = 90-92
        B+ = 87-89
        B = 83-86
        B- = 80-82
        C+ = 77-79
        C = 73-76
        C- = 70-72
        D+ = 67-69
        D = 63-66
        D- = 60-62
        F = 0-59

        Rounding too!
         */




        Scanner input = new Scanner(System.in);
        System.out.print("Grade: ");
        String user_grade = input.nextLine();
        String letter_grade = "F";

        int grade;
        try {
            // Convert the user's input to a double and round it to the nearest integer
            grade = (int) Math.round(Double.parseDouble(user_grade));
            System.out.println("Grade rounded to " + grade);
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid grade!");
        }

        if (grade >= 97) letter_grade = "A+";
        else if (grade >= 93) letter_grade = "A";
        else if (grade >= 90) letter_grade = "A-";
        else if (grade >= 87) letter_grade = "B+";
        else if (grade >= 83) letter_grade = "B";
        else if (grade >= 80) letter_grade = "B-";
        else if (grade >= 77) letter_grade = "C+";
        else if (grade >= 73) letter_grade = "C";
        else if (grade >= 70) letter_grade = "C-";
        else if (grade >= 67) letter_grade = "D+";
        else if (grade >= 63) letter_grade = "D";
        else if (grade >= 60) letter_grade = "D-";

        System.out.println("Letter grade: " + letter_grade);
    }
}
