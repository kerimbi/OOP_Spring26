public interface Drawable {
    void draw();               
    default void print() {      
        System.out.println("Rendering: " + getClass().getSimpleName());
    }
}