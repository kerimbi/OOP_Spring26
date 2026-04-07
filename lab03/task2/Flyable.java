public interface Flyable extends Moveable {
    void fly(int dz);          
    int getAltitude();
    void land();
    default boolean isAirborne() { return getAltitude() > 0; }
}