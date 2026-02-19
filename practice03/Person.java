package practice03;

public class Person {
    private final String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "[PERSON] " + "Name: " + name + " | Address: " + address;
    }
}