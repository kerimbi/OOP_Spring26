import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Employee extends Person
        implements Comparable<Employee>, Cloneable {

    private double salary;
    private Date   hireDate;
    private String nationalInsuranceNumber;

    public Employee(String name, double salary, Date hireDate, String nin) {
        super(name);
        this.salary = salary;
        this.hireDate = new Date(hireDate.getTime());  
        this.nationalInsuranceNumber = nin;
    }
    public Employee(String name, double salary) {
        this(name, salary, new Date(), "N/A");
    }

    public double getSalary()      { return salary; }
    public void   setSalary(double s) { this.salary = s; }
    public Date   getHireDate()    { return new Date(hireDate.getTime()); }
    public String getNIN()         { return nationalInsuranceNumber; }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    public static final Comparator<Employee> BY_NAME =
        Comparator.comparing(e -> e.name);

    public static final Comparator<Employee> BY_HIRE_DATE =
        Comparator.comparing(Employee::getHireDate);

    @Override
    public String toString() {
        return "Employee{name="+name+", salary="+salary+
               ", hired="+hireDate+", NIN="+nationalInsuranceNumber+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return Objects.equals(name, e.name) &&
               Objects.equals(nationalInsuranceNumber, e.nationalInsuranceNumber);
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.hireDate = new Date(this.hireDate.getTime()); 
            return copy;
        } catch (CloneNotSupportedException ex) { throw new AssertionError(); }
    }
}