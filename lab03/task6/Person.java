import java.util.Objects;

abstract class Person
        implements Comparable<Person>, Cloneable, Describable {

    private final String name;
    private final int age;
    protected Animal pet;          
    private Animal boardedPet;
    private Person currentCaretaker;

    protected Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public boolean assignPet(Animal pet) {
        if (!canAcceptPet(pet)) {
            System.out.println("  ERROR: " + name + " cannot accept a "
                + pet.getClass().getSimpleName() + ".");
            return false;
        }
        this.pet = pet;
        return true;
    }

    public Animal removePet()         { Animal r = pet; pet = null; return r; }
    public boolean hasPet()           { return pet != null; }
    public Animal  getPet()           { return pet; }
    public String  getName()          { return name; }
    public int     getAge()           { return age; }
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
            System.out.println("  ERROR: " + caretaker.getName()
                + " cannot accept a " + pet.getClass().getSimpleName() + ".");
            return false;
        }
        boardedPet = pet;
        currentCaretaker = caretaker;
        caretaker.pet = pet;
        pet = null;
        System.out.println(name + " left " + boardedPet.getName()
            + " with " + caretaker.getName() + ".");
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
        System.out.println(name + " retrieved " + pet.getName()
            + " from " + caretaker.getName() + ".");
        return true;
    }

    public abstract String getOccupation();

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public Person clone() {
        try {
            Person copy = (Person) super.clone();
            if (this.pet != null)
                copy.pet = this.pet.clone();
            return copy;
        } catch (CloneNotSupportedException e) { throw new AssertionError(); }
    }

    @Override
    public String describe() {
        return name + " (" + getOccupation() + ", age " + age + ")"
             + (hasPet() ? ", has pet: " + pet.getName() : ", no pet");
    }

    @Override
    public String toString() {
        String petStr   = pet != null ? pet.toString() : "none";
        String boarding = boardedPet != null
            ? ", boarding=" + boardedPet.getName() + " with " + currentCaretaker.getName()
            : "";
        return getClass().getSimpleName() + "[" + name + ", age=" + age
             + ", " + getOccupation() + ", pet=" + petStr + boarding + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person p)) return false;
        return age == p.age && name.equals(p.name) && getClass() == p.getClass();
    }

    @Override
    public int hashCode() { return Objects.hash(name, age, getClass()); }
}