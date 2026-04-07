import java.util.*;

public class TestEmployee {
    public static void main(String[] args) {
        Date d1 = new GregorianCalendar(2020,0,15).getTime();
        Date d2 = new GregorianCalendar(2018,5,1).getTime();
        Date d3 = new GregorianCalendar(2022,3,10).getTime();

        Employee alice = new Employee("Alice", 60000, d1, "AB123");
        Employee bob   = new Employee("Bob",   75000, d2, "CD456");
        Manager  carol = new Manager ("Carol", 90000, d3, "EF789", 15000);
        carol.addToTeam(alice);
        carol.addToTeam(bob);

        List<Employee> staff = Arrays.asList(carol, bob, alice);

        System.out.println("--- natural order (salary) ---");
        Collections.sort(staff);
        staff.forEach(System.out::println);

        System.out.println("--- by name ---");
        staff.sort(Employee.BY_NAME);
        staff.forEach(System.out::println);

        System.out.println("--- by hire date ---");
        staff.sort(Employee.BY_HIRE_DATE);
        staff.forEach(System.out::println);

        System.out.println("--- clone test ---");
        Employee aliceCopy = alice.clone();
        System.out.println(aliceCopy);
        System.out.println("same object? " + (alice == aliceCopy));
        System.out.println("equals?      " + alice.equals(aliceCopy));
    }
}