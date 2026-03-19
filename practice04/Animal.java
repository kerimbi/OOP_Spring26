public abstract class Animal implements LivingBeing {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void breathe();
    public abstract void move();
    public abstract void eat();
}