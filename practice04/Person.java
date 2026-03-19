public class Person implements LivingBeing {
    String name;
    int age;
    String city;

    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public void move()    { System.out.println(name + " walks."); }
    public void breathe() { System.out.println(name + " breathes."); }
    public void eat()     { System.out.println(name + " eats food."); }
}

class Student extends Person implements CanHavePizza, CanHaveRetake, CanHaveParty, Payable {
    double gpa;
    String major;
    double balance;
 
    Student(String name, int age, String city, double gpa, String major, double balance) {
        super(name, age, city);
        this.gpa = gpa;
        this.major = major;
        this.balance = balance;
    }


    public void eatPizza()   { System.out.println(name + " eats pizza after coding all night!"); }
    public void takeRetake() { System.out.println(name + " goes to take a retake. Good luck!"); }
    public void dance()      { System.out.println(name + " dances at the party!"); }

    public double getBalance() { return balance; }
    public void pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(name + " paid $" + amount + ". Remaining: $" + balance);
        } else {
            System.out.println(name + " has insufficient balance!");
        }
    }
    public String toString() {
        return "Student[" + name + ", GPA=" + gpa + ", major=" + major + "]";
    }
}