import java.util.Date;

public class EmploymentHistory {

    private Date startDate;
    private final Date endDate;
    private String position;
    private double salary;

    public EmploymentHistory(Employee employee, Date startDate, Date endDate, String position, double salary) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}