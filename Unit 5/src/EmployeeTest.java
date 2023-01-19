/**
 * This class tests the Employee class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-19
 * @see EmployeeTest
 * @see Employee
 */

public class EmployeeTest {
    /**
     * Tests the Employee class.
     * @param args the command line arguments (not used).
     */
    public static void main(String[] args) {
        // Make two employees
        Employee employee = new Employee("Jacob", 55000);
        Employee employee2 = new Employee();
        // Print their names and salaries
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary of " + employee.getName() + ": " + employee.getFormatSalary());
        System.out.println("Name: " + employee2.getName());
        System.out.println("Salary of " + employee.getName() + ": " + employee2.getFormatSalary());
        // Raise their salaries by 10%
        employee.raiseSalary(10);
        System.out.println("Salary of " + employee.getName() + ": " + employee.getFormatSalary());
        employee2.raiseSalary(10);
        System.out.println("Salary of " + employee2.getName() + ": " + employee2.getFormatSalary());
    }
}
