public class Student {
    private String name;
    private String major;
    private double gpa;

    public Student(String name, String major, double gpa) {
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }
    //Create methods that return each element and another one to return all the elements.

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return "Name: " + name + ", Major: " + major + ", GPA: " + gpa;
    }
}
