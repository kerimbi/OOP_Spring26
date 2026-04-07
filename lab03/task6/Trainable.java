import java.util.List;

public interface Trainable {
    void    learn(String command);
    boolean knows(String command);
    List<String> getKnownCommands();
}