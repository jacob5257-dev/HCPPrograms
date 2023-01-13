import java.util.List;
import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        //Initalize 5 students, store them in the ArrayList, and print the names, degrees, and GPAs of all the students.

        students.add(new Student("John", "Computer Science", 3.5));
        students.add(new Student("Jane", "Computer Science", 3.8));
        students.add(new Student("Jack", "Computer Science", 3.2));
        students.add(new Student("Jill", "Computer Science", 3.9));
        students.add(new Student("Joe", "Computer Science", 3.1));

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }
}
