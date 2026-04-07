public class TestFlyable {

    public static void main(String[] args) {

        System.out.println("=== Moveable + Flyable interfaces ===");

        Bird eagle = new Bird("Eagle");
        eagle.move(10, 5);
        eagle.fly(200);
        System.out.println(eagle);
        System.out.println("Airborne? " + eagle.isAirborne());  // default method
        eagle.land();
        System.out.println("After land: " + eagle);
        System.out.println("Airborne? " + eagle.isAirborne());

        System.out.println();

        Drone drone = new Drone("DJI-X", 100.0);
        drone.fly(50);
        drone.move(3, 3);
        System.out.println("Drone altitude: " + drone.getAltitude());
        System.out.println("Battery left: "  + drone.getBattery() + "%");

        System.out.println();

        // Polymorphism — treat both as Flyable
        Flyable[] flyers = { eagle, drone };
        System.out.println("--- fly all up by 100 ---");
        for (Flyable f : flyers) {
            f.fly(100);
            System.out.println("altitude: " + f.getAltitude());
        }

        // Treat both as Moveable (only move, no fly)
        Moveable[] movers = { eagle, drone };
        System.out.println("--- move all ---");
        for (Moveable m : movers) {
            m.move(1, 1);
            System.out.println("pos: (" + m.getX() + "," + m.getY() + ")");
        }
    }
}