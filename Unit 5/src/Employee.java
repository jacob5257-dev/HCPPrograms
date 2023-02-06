import java.text.DecimalFormat;

/**
 * This class represents an employee in a company.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-19
 * @see EmployeeTest
 * @see Employee
 */
public class Employee {
    // Instance variables
    private String name;
    private double salary;

    /**
     * Constructs an employee with a given name and salary.
     * @param name the name of the employee
     * @param salary the salary of the employee
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Constructs an employee with a default name and salary.
     */
    public Employee() {
        this("John Doe", 0.0);
    }

    /**
     * Gets the name of the employee.
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the salary of the employee.
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the salary of the employee in a formatted string.
     * @return the salary of the employee in a formatted string
     */
    public String getFormatSalary() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(salary);
    }

    /**
     * Raises the salary of the employee by a given percentage.
     * @param percent the percentage to raise the salary by
     */
    public void raiseSalary(double percent) {
        double raise = salary * percent / 100;
        salary += raise;
    }

    /**
     * Changes the name of the employee.
     * @param name the new name of the employee
     */
    public void changeName(String name) {
        this.name = name;
    }
}