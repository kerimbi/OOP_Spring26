public class Cat extends Animal implements CanHavePizza {
    String furColor;

    Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    public void breathe() { System.out.println(name + " breathes."); }
    public void move()    { System.out.println(name + " moves gracefully."); }
    public void eat()     { System.out.println(name + " eats fish."); }

    public void eatPizza() {
        System.out.println(name + " the cat sniffs the pizza and takes a tiny bite.");
    }
}