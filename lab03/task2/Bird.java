public class Bird implements Flyable {
    private int x, y, altitude;
    private String name;

    public Bird(String name) { this.name = name; }

    @Override public void move(int dx, int dy) { x += dx; y += dy; }
    @Override public void fly(int dz)   { altitude += dz; }
    @Override public void land()       { altitude = 0; }
    @Override public int  getX()       { return x; }
    @Override public int  getY()       { return y; }
    @Override public int  getAltitude() { return altitude; }

    @Override public String toString() {
        return name + " at ("+x+","+y+") alt="+altitude;
    }
}