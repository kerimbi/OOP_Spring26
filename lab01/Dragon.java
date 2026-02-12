import java.util.Vector;

enum Gender {
    BOY, GIRL
}

class Person {
    private Gender gender;
    private String name;
    
    public Person(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name + " (" + (gender == Gender.BOY ? "B" : "G") + ")";
    }
}

public class Dragon {
    private Vector<Person> prisoners;
    
    public Dragon() {
        prisoners = new Vector<>();
    }
    
    public void kidnap(Person p) {
        prisoners.add(p);
        System.out.println("Dragon kidnapped: " + p);
    }
    
    public void willDragonEatOrNot() {
        System.out.println("\nInitial line:");
        printLine();
        
        int remaining = countRemaining();
        
        System.out.println("\nAfter magic of love:");
        if (remaining == 0) {
            System.out.println("No launch for dragon today! All students vanished!");
        } else {
            System.out.println("Dragon will eat " + remaining + " student(s) for launch!");
        }
    }
    
    private int countRemaining() {
        int count = 0;
        
        for (int i = 0; i < prisoners.size(); i++) {
            if (prisoners.get(i).getGender() == Gender.BOY) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                }
            }
        }
        
        return count;
    }
    
    private void printLine() {
        for (Person p : prisoners) {
            System.out.print(p.getGender() == Gender.BOY ? "B" : "G");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        
        System.out.println("=== Dragon's Morning Hunt ===\n");
        
        dragon.kidnap(new Person(Gender.BOY, "Arman"));
        dragon.kidnap(new Person(Gender.BOY, "Dias"));
        dragon.kidnap(new Person(Gender.GIRL, "Aigerim"));
        dragon.kidnap(new Person(Gender.GIRL, "Madina"));
        
        dragon.willDragonEatOrNot();
        
        System.out.println("\n=== Another Day ===\n");
        
        Dragon dragon2 = new Dragon();
        
        dragon2.kidnap(new Person(Gender.GIRL, "Asel"));
        dragon2.kidnap(new Person(Gender.BOY, "Berik"));
        dragon2.kidnap(new Person(Gender.GIRL, "Dana"));
        dragon2.kidnap(new Person(Gender.BOY, "Erbol"));
        
        dragon2.willDragonEatOrNot();
    }
}