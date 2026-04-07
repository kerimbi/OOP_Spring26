import java.util.ArrayList;
import java.util.List;

class Dog extends Animal implements Trainable {

    private List<String> commands = new ArrayList<>();

    public Dog(String n, int a) { super(n, a); }

    @Override public String getSound() { return "Woof"; }


    @Override
    public void learn(String command) {
        if (!commands.contains(command)) commands.add(command);
    }
    @Override
    public boolean knows(String command) { return commands.contains(command); }
    @Override
    public List<String> getKnownCommands() { return List.copyOf(commands); }

    @Override
    public Dog clone() {
        Dog copy = (Dog) super.clone();
        copy.commands = new ArrayList<>(this.commands);
        return copy;
    }
}