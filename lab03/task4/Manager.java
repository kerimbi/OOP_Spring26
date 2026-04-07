import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {
    private double bonus;
    private Vector<Employee> team;

    public Manager(String name, double salary, Date hireDate, String nin, double bonus) {
        super(name, salary, hireDate, nin);
        this.bonus = bonus;
        this.team  = new Vector<>();
    }

    public double           getBonus()          { return bonus; }
    public void             setBonus(double b)  { this.bonus = b; }
    public Vector<Employee> getTeam()            { return team; }
    public void             addToTeam(Employee e){ team.add(e); }

    @Override
    public int compareTo(Employee other) {
        int cmp = super.compareTo(other);
        if (cmp != 0) return cmp;
        if (other instanceof Manager)
            return Double.compare(this.bonus, ((Manager) other).bonus);
        return 0;
    }

    @Override
    public String toString() {
        return "Manager{name="+name+", salary="+getSalary()+
               ", bonus="+bonus+", team="+team.size()+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Manager)) return false;
        return Double.compare(bonus, ((Manager)o).bonus) == 0;
    }

    @Override
    public Manager clone() {
        Manager copy = (Manager) super.clone();
        copy.team = new Vector<>();
        for (Employee e : team) copy.team.add(e.clone());
        return copy;
    }
}