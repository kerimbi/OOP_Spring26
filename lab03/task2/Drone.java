public class Drone implements Flyable {
    private int x, y, altitude;
    private String model;
    private double batteryPct;

    public Drone(String model, double battery) {
        this.model = model; this.batteryPct = battery;
    }

    @Override public void move(int dx, int dy) {
        if (batteryPct > 0) { x += dx; y += dy; batteryPct -= 0.5; }
    }
    @Override public void fly(int dz) {
        if (batteryPct > 0) { altitude += dz; batteryPct -= 1.0; }
    }
    @Override public void land()        { altitude = 0; }
    @Override public int  getX()        { return x; }
    @Override public int  getY()        { return y; }
    @Override public int  getAltitude()  { return altitude; }
    public double getBattery()         { return batteryPct; }
}