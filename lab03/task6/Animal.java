abstract class Animal implements Comparable<Animal>, Cloneable, Describable {

    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public String getName() { return name; }
    public int    getAge()  { return age; }

    public abstract String getSound();

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public Animal clone() {
        try { return (Animal) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(); }
    }

    @Override
    public String describe() {
        return "I am " + name + ", a " + getClass().getSimpleName()
             + ", age " + age + ". I say: " + getSound();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + name + ", age=" + age
             + ", sound=" + getSound() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal a)) return false;
        return age == a.age && name.equals(a.name) && getClass() == a.getClass();
    }

    @Override
    public int hashCode() { return 31 * name.hashCode() + age; }
}