import java.util.Arrays;

public class TestTask6 {

    public static void main(String[] args) {

        System.out.println("=== Comparable (sort by age) ===");
        Person john  = new Employee("John",  30, "Architect");
        Person alice = new PhDStudent("Alice", 26, "Comp Science", "AI");
        Person bob   = new Student("Bob",    22, "Biology");

        Person[] people = { john, alice, bob };
        System.out.println("Before sort: " + Arrays.toString(people));
        Arrays.sort(people); // uses compareTo
        System.out.println("After (by age): " + Arrays.toString(people));

        System.out.println();
        System.out.println("=== Describable ===");
        john.printDescription();
        alice.printDescription();

        Animal murka = new Cat("Murka", 5);
        Animal rex   = new Dog("Rex",   3);
        murka.printDescription();
        rex.printDescription();

        System.out.println();
        System.out.println("=== Trainable (Dog and Cat only) ===");
        Dog rexDog = new Dog("Rex", 3);
        rexDog.learn("sit");
        rexDog.learn("paw");
        rexDog.learn("sit"); // duplicate — ignored
        System.out.println("Rex knows 'sit':  " + rexDog.knows("sit"));  // true
        System.out.println("Rex knows 'roll': " + rexDog.knows("roll")); // false
        System.out.println("Rex commands: "      + rexDog.getKnownCommands());

        Cat murkaCat = new Cat("Murka", 5);
        murkaCat.learn("come");
        System.out.println("Murka commands: " + murkaCat.getKnownCommands());

        System.out.println();
        System.out.println("=== Cloneable ===");

        john.assignPet(murka);
        Person johnCopy = john.clone();
        System.out.println("same ref?     " + (john == johnCopy));               // false
        System.out.println("equals?       " + john.equals(johnCopy));             // true
        System.out.println("pet same ref? " + (john.getPet() == johnCopy.getPet())); // false — deep copy

        // Dog clone — deep copy of commands list
        Dog rexCopy = rexDog.clone();
        rexCopy.learn("roll");
        System.out.println("Original Rex: " + rexDog.getKnownCommands());  // no roll
        System.out.println("Cloned Rex:   " + rexCopy.getKnownCommands()); // has roll

        System.out.println();
        System.out.println("=== Animal Comparable ===");
        Animal[] animals = {
            new Cat("Whiskers", 7),
            new Dog("Rex",      3),
            new Bird("Tweety",  1),
            new Fish("Nemo",    4)
        };
        Arrays.sort(animals);
        System.out.println("Sorted by age: " + Arrays.toString(animals));
    }
}