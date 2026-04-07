public interface Describable {
    String describe();
    default void printDescription() {
        System.out.println(describe());
    }
}