public class TestInterfaceVsAbstract {

    public static void main(String[] args) {

        System.out.println("=== Interface vs Abstract Class ===");

        Circle c = new Circle("red", 5.0);
        c.draw();
        c.print();  
        System.out.println("Area: " + c.area());
        c.resize(2.0);
        System.out.println("Area after resize x2: " + c.area());

        System.out.println();

        Button btn = new Button("Submit");
        btn.draw();
        btn.print();

        System.out.println();

        Drawable[] drawables = { c, btn };
        System.out.println("--- draw all via Drawable[] ---");
        for (Drawable d : drawables) d.draw();
    }
}