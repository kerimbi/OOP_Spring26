
abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getCurrent() { return getPotentialDiff() / getResistance(); }
    public double getPower()   { return getPotentialDiff() * getCurrent(); }
}

class Resistor extends Circuit {
    private final double resistance;
    private double potentialDiff;

    public Resistor(double resistance) { this.resistance = resistance; }

    @Override public double getResistance()   { return resistance; }
    @Override public double getPotentialDiff() { return potentialDiff; }
    @Override public void applyPotentialDiff(double V) { potentialDiff = V; }

}

class Series extends Circuit {
    private final Circuit first, second;

    public Series(Circuit first, Circuit second) { this.first = first; this.second = second; }

    @Override public double getResistance() { return first.getResistance() + second.getResistance(); }
    @Override public double getPotentialDiff() { return first.getPotentialDiff() + second.getPotentialDiff(); }

    @Override
    public void applyPotentialDiff(double V) {
        double I = V / getResistance();
        first.applyPotentialDiff(I * first.getResistance());
        second.applyPotentialDiff(I * second.getResistance());
    }

}

class Parallel extends Circuit {
    private final Circuit first, second;

    public Parallel(Circuit first, Circuit second) { this.first = first; this.second = second; }

    @Override
    public double getResistance() {
        return 1.0 / (1.0 / first.getResistance() + 1.0 / second.getResistance());
    }

    @Override public double getPotentialDiff() { return first.getPotentialDiff(); }

    @Override
    public void applyPotentialDiff(double V) {
        first.applyPotentialDiff(V);
        second.applyPotentialDiff(V);
    }


}

public class MainElectricalCircuit {
    public static void main(String[] args) {
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);
        Circuit g = new Parallel(c, d);
        Circuit h = new Series(g, e);
        Circuit circuit = new Parallel(h, f);

        double R = circuit.getResistance();
        System.out.printf("Equivalent resistance: %.2f %n", R);

        double V = 12.0;
        circuit.applyPotentialDiff(V);
        System.out.printf("Applied voltage: %.2f V%n", V);
        System.out.printf("Total current: %.2f A%n", circuit.getCurrent());
        System.out.printf("Total power: %.2f W%n", circuit.getPower());
    }
}