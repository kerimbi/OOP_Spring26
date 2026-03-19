import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) { this.name = name; this.age = age; }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public abstract String getSound();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + name + ", age=" + age + ", sound=" + getSound() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal a)) return false;
        return age == a.age && name.equals(a.name) && getClass() == a.getClass();
    }

    @Override
    public int hashCode() { return 31 * name.hashCode() + age; }
}

class Cat  extends Animal { public Cat(String n, int a)  { super(n,a); } @Override public String getSound() { return "Meow";  } }
class Dog  extends Animal { public Dog(String n, int a)  { super(n,a); } @Override public String getSound() { return "Woof";  } }
class Bird extends Animal { public Bird(String n, int a) { super(n,a); } @Override public String getSound() { return "Tweet"; } }
class Fish extends Animal { public Fish(String n, int a) { super(n,a); } @Override public String getSound() { return "Blub";  } }

abstract class Person {
    private final String name;
    private final int age;
    private Animal pet;
    private Animal boardedPet;
    private Person currentCaretaker;

    protected Person(String name, int age) { this.name = name; this.age = age; }

    public boolean assignPet(Animal pet) {
        if (!canAcceptPet(pet)) {
            System.out.println("  ERROR: " + name + " cannot accept a " + pet.getClass().getSimpleName() + ".");
            return false;
        }
        this.pet = pet;
        return true;
    }

    public Animal removePet() { Animal r = pet; pet = null; return r; }

    public boolean hasPet()    { return pet != null; }
    public Animal getPet()     { return pet; }
    public String getName()    { return name; }
    public int    getAge()     { return age; }

    public boolean canAcceptPet(Animal pet) { return true; }

    public boolean leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println("  ERROR: " + name + " has no pet to leave.");
            return false;
        }
        if (boardedPet != null) {
            System.out.println("  ERROR: " + name + " is already on vacation.");
            return false;
        }
        if (caretaker.hasPet()) {
            System.out.println("  ERROR: " + caretaker.getName() + " already has a pet.");
            return false;
        }
        if (!caretaker.canAcceptPet(pet)) {
            System.out.println("  ERROR: " + caretaker.getName() + " cannot accept a " + pet.getClass().getSimpleName() + ".");
            return false;
        }

        boardedPet = pet;
        currentCaretaker = caretaker;
        caretaker.pet = pet;
        pet = null;
        System.out.println(name + " left " + boardedPet.getName() + " with " + caretaker.getName() + ".");
        return true;
    }

    public boolean retrievePetFrom(Person caretaker) {
        if (boardedPet == null) {
            System.out.println("  ERROR: " + name + " is not on vacation.");
            return false;
        }
        if (!caretaker.equals(currentCaretaker)) {
            System.out.println("  ERROR: Pet is not with " + caretaker.getName() + ".");
            return false;
        }

        pet = boardedPet;
        caretaker.pet = null;
        boardedPet = null;
        currentCaretaker = null;
        System.out.println(name + " retrieved " + pet.getName() + " from " + caretaker.getName() + ".");
        return true;
    }

    public abstract String getOccupation();

    @Override
    public String toString() {
        String petStr   = pet != null ? pet.toString() : "none";
        String boarding = boardedPet != null ? ", boarding=" + boardedPet.getName() + " with " + currentCaretaker.getName() : "";
        return getClass().getSimpleName() + "[" + name + ", age=" + age + ", " + getOccupation() + ", pet=" + petStr + boarding + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person p)) return false;
        return age == p.age && name.equals(p.name) && getClass() == p.getClass();
    }

    @Override
    public int hashCode() { return Objects.hash(name, age, getClass()); }
}

class Employee extends Person {
    private final String jobTitle;

    public Employee(String name, int age, String jobTitle) { super(name, age); this.jobTitle = jobTitle; }

    public String getJobTitle() { return jobTitle; }

    @Override public String getOccupation() { return "Employee(" + jobTitle + ")"; }

    @Override
    public boolean equals(Object o) { return super.equals(o) && jobTitle.equals(((Employee) o).jobTitle); }

    @Override
    public int hashCode() { return 31 * super.hashCode() + jobTitle.hashCode(); }
}

class Student extends Person {
    private final String major;

    public Student(String name, int age, String major) { super(name, age); this.major = major; }

    public String getMajor() { return major; }

    @Override public String getOccupation() { return "Student(major=" + major + ")"; }

    @Override
    public boolean equals(Object o) { return super.equals(o) && major.equals(((Student) o).major); }

    @Override
    public int hashCode() { return 31 * super.hashCode() + major.hashCode(); }
}

class PhDStudent extends Person {
    private final String major;
    private final String researchTopic;

    public PhDStudent(String name, int age, String major, String researchTopic) {
        super(name, age);
        this.major = major;
        this.researchTopic = researchTopic;
    }

    public String getMajor()         { return major; }
    public String getResearchTopic() { return researchTopic; }

    @Override
    public boolean canAcceptPet(Animal pet) {
        if (pet instanceof Dog) return false;
        return true;
    }

    @Override public String getOccupation() { return "PhDStudent(major=" + major + ", research=" + researchTopic + ")"; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        PhDStudent p = (PhDStudent) o;
        return major.equals(p.major) && researchTopic.equals(p.researchTopic);
    }

    @Override
    public int hashCode() { return 31 * super.hashCode() + major.hashCode() + researchTopic.hashCode(); }
}

class PersonRegistry {
    private final List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        if (people.contains(p)) {
            System.out.println("  ERROR: " + p.getName() + " already registered.");
        } else {
            people.add(p);
        }
    }

    public boolean removePerson(Person p)      { return people.remove(p); }
    
    @Override   
    public String toString() {
        StringBuilder sb = new StringBuilder("PersonRegistry\n");
        people.forEach(p -> sb.append("  ").append(p).append("\n"));
        return sb.append("=>").toString();
    }
}

public class MainPetManagement {
    public static void main(String[] args) {
        Person john  = new Employee("John", 30, "Architect");
        Person alice = new PhDStudent("Alice", 26, "Comp Science", "AI");
        Animal murka = new Cat("Murka", 5);

        john.assignPet(murka);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);

        System.out.println(registry);

        john.leavePetWith(alice);
        System.out.println(registry);

        john.retrievePetFrom(alice);
        System.out.println(registry);

        System.out.println("\nError handling");

        System.out.println("Alice tries to get a Dog:");
        alice.assignPet(new Dog("Rex", 3));

        Person bob = new Student("Bob", 22, "Biology");
        bob.assignPet(new Dog("Rex", 3));
        registry.addPerson(bob);

        System.out.println("Bob tries to leave Rex with Alice:");
        bob.leavePetWith(alice);

        alice.assignPet(new Fish("Nemo", 1));
        System.out.println("Bob tries to leave Rex with Alice (has Nemo):");
        bob.leavePetWith(alice);
    }
}