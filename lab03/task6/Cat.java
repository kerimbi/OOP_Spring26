import java.util.ArrayList;
import java.util.List;

class Cat extends Animal implements Trainable {

    private List<String> commands = new ArrayList<>();

    public Cat(String n, int a) { super(n, a); }

    @Override public String getSound() { return "Meow"; }

    @Override
    public void learn(String command) {
        if (!commands.contains(command)) commands.add(command);
    }
    @Override
    public boolean knows(String command) { return commands.contains(command); }
    @Override
    public List<String> getKnownCommands() { return List.copyOf(commands); }

    @Override
    public Cat clone() {
        Cat copy = (Cat) super.clone();
        copy.commands = new ArrayList<>(this.commands);
        return copy;
    }
}