abstract class Shape3D {
    public abstract double volume();
    public abstract double surfaceArea();
    public abstract String name();

    @Override
    public String toString() {
        return String.format("%s[Volume=%.2f, SurfaceArea=%.2f]", name(), volume(), surfaceArea());
    }
}

class Cylinder extends Shape3D {
    private double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override public double volume()      { return Math.PI * radius * radius * height; }
    @Override public double surfaceArea() { return 2 * Math.PI * radius * (radius + height); }
    @Override public String name()        { return "Cylinder(r=" + radius + ", h=" + height + ")"; }
}

class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) { this.radius = radius; }

    @Override public double volume()      { return (4.0 / 3.0) * Math.PI * radius * radius * radius; }
    @Override public double surfaceArea() { return 4 * Math.PI * radius * radius; }
    @Override public String name()        { return "Sphere(r=" + radius + ")"; }
}

class Cube extends Shape3D {
    private double side;

    public Cube(double side) { this.side = side; }

    @Override public double volume()      { return side * side * side; }
    @Override public double surfaceArea() { return 6 * side * side; }
    @Override public String name()        { return "Cube(s=" + side + ")"; }
}

public class MainShapes3D {
    public static void main(String[] args) {
        Shape3D[] shapes = {
            new Cylinder(3, 7),
            new Sphere(5),
            new Cube(4)
        };

        for (Shape3D s : shapes) System.out.println(s);


        /*System.out.println("\nLargest by Volume");
        Shape3D largest = shapes[0];
        for (Shape3D s : shapes) if (s.volume() > largest.volume()) largest = s;
        System.out.println(largest.name());*/
    }
}