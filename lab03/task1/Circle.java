public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override public void draw() {
        System.out.println("Drawing circle r=" + radius + " color=" + color);
    }
    @Override public void resize(double factor) { radius *= factor; }
    @Override public double area() { return Math.PI * radius * radius; }
}