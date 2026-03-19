import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cat borsik = new Cat("Borsik", 6, "black");
        Student adiya   = new Student("Adiya",   19, "Almaty", 3.8, "MCM", 50);
        Student askhat  = new Student("Askhat",  21, "Taraz",  3.5, "Math", 34);
        Student mansur = new Student("Mansur", 20, "Astana", 3.7, "IT", 15);

        servePizza(borsik);
        servePizza(adiya);
        servePizza(askhat);
        servePizza(mansur);

        CashRegister register = new CashRegister("Del Papa Cashier", 17);
        register.charge(adiya);   
        register.charge(askhat);
        register.charge(mansur);

        System.out.println("\nanimal actions:");
        List<Animal> animals = new ArrayList<>();
        animals.add(borsik);
        for (Animal a : animals) {
            a.breathe();
            a.move();
            a.eat();
        }

        System.out.println("\nstudent actions:");
        adiya.dance();
        askhat.takeRetake();
        mansur.eatPizza();
        

        System.out.println("\nsort students by GPA:");
        List<Student> students = new ArrayList<>();
        students.add(adiya);
        students.add(askhat);
        students.add(mansur);
 
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                if (a.gpa > b.gpa) return -1;
                if (a.gpa < b.gpa) return  1;
                return 0;
            }
        });
        for (Student s : students) System.out.println("  " + s);
    }


    static void servePizza(CanHavePizza eater) {
        System.out.println("\n[Del Papa] Serving pizza...");
        eater.eatPizza();
        if (eater instanceof Person) {
            System.out.println("  -> Sending to cash register...");
        } else {
            System.out.println("  -> No payment needed (it's a cat).");
        }
    }
}