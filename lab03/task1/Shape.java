public abstract class Shape implements Drawable, Resizable {
    protected String color;

    public Shape(String color) { this.color = color; }
    public String getColor() { return color; }
    public abstract double area();
}