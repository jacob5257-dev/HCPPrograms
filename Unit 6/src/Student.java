/**
 * Student class that contains the name, major, and gpa of a student.
 * @see StudentTest
 * @see StudentTest#main(String[])
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class Student {
    // Creates instance variables
    private String name;
    private String major;
    private double gpa;

    /**
     * Constructor for the Student class
     * @param name The name of the student
     * @param major The major of the student
     * @param gpa The GPA of the student
     */
    public Student(String name, String major, double gpa) {
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }
    //Create methods that return each element and another one to return all the elements.

    /**
     * Returns the name of the student
     * @return The name of the student (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the major of the student
     * @return The major of the student (String)
     */
    public String getMajor() {
        return major;
    }

    /**
     * Returns the GPA of the student
     * @return The GPA of the student (double)
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Returns all the information of the student. Used in System.out.print()
     * @return The name, major, and GPA of the student (String)
     */
    public String toString() {
        return "Name: " + name + ", Major: " + major + ", GPA: " + gpa;
    }
}
