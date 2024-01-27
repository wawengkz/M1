public class EmployeeRecord {
    public Employee employee;
    public int month;
    public double[] hoursWorked;
    public double totalSalary;

    public EmployeeRecord(Employee employee, int month, double[] hoursWorked, double totalSalary) {
        this.employee = employee;
        this.month = month;
        this.hoursWorked = hoursWorked;
        this.totalSalary = totalSalary;
    }

    // Additional methods as necessary
}