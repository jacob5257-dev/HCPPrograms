// Imports list classes
import java.util.List;
import java.util.ArrayList;

/**
 * This class tests the Student class
 * @see Student
 * @see Student#Student(String, String, double)
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class StudentTest {
    /**
     * This method tests the Student class
     * @param args The command line arguments (unused)
     */
    public static void main(String[] args) {
        // Creates the ArrayList for the Students to be put in.
        List<Student> students = new ArrayList<>();
        //Initialize 5 students, store them in the ArrayList, and print the names, degrees, and GPAs of all the students.

        students.add(new Student("John", "Computer Science", 3.5));
        students.add(new Student("Jane", "Computer Science", 3.8));
        students.add(new Student("Jack", "Computer Science", 3.2));
        students.add(new Student("Jill", "Computer Science", 3.9));
        students.add(new Student("Joe", "Computer Science", 3.1));
        // Prints out all the important values of the students.
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
