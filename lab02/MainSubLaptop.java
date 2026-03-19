import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Laptop {
    private String brand;
    private String processor;
    private int ramGB;

    public Laptop(String brand, String processor, int ramGB) {
        this.brand = brand;
        this.processor = processor;
        this.ramGB = ramGB;
    }

    public String getBrand()     { return brand; }
    public String getProcessor() { return processor; }
    public int getRamGB()        { return ramGB; }

    @Override
    public String toString() {
        return "Laptop[brand=" + brand + ", cpu=" + processor + ", ram=" + ramGB + "GB]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop l)) return false;
        return ramGB == l.ramGB && brand.equals(l.brand) && processor.equals(l.processor);
    }

    @Override
    public int hashCode() { return Objects.hash(brand, processor, ramGB); }
}

class GamingLaptop extends Laptop {
    private String gpu;
    private int refreshRateHz;

    public GamingLaptop(String brand, String processor, int ramGB, String gpu, int refreshRateHz) {
        super(brand, processor, ramGB);
        this.gpu = gpu;
        this.refreshRateHz = refreshRateHz;
    }

    public String getGpu()         { return gpu; }
    public int getRefreshRateHz()  { return refreshRateHz; }

    @Override
    public String toString() {
        return "GamingLaptop[brand=" + getBrand() + ", cpu=" + getProcessor() + ", ram=" + getRamGB() + "GB, gpu=" + gpu + ", " + refreshRateHz + "Hz]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamingLaptop g)) return false;
        return super.equals(o) && refreshRateHz == g.refreshRateHz && gpu.equals(g.gpu);
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), gpu, refreshRateHz); }
}

public class MainSubLaptop {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        Laptop l1 = new Laptop("Apple", "M3", 16);
        Laptop l2 = new Laptop("Apple", "M3", 16);       // duplicate of l1
        Laptop l3 = new Laptop("Apple", "M3", 8);        // different RAM
        Laptop l4 = new Laptop("Dell", "Intel i7", 16);

        GamingLaptop g1 = new GamingLaptop("ASUS", "Intel i9", 32, "RTX 4070", 165);
        GamingLaptop g2 = new GamingLaptop("ASUS", "Intel i9", 32, "RTX 4070", 165);  // duplicate of g1
        GamingLaptop g3 = new GamingLaptop("ASUS", "Intel i9", 32, "RTX 4070", 144);  // different Hz
        GamingLaptop g4 = new GamingLaptop("MSI", "AMD Ryzen 9", 32, "RTX 4080", 240);

        laptops.add(l1);
        laptops.add(l2);  // duplicate
        laptops.add(l3);
        laptops.add(l4);
        laptops.add(g1);
        laptops.add(g2);  // duplicate
        laptops.add(g3);
        laptops.add(g4);

        System.out.println("\nItems:");
        laptops.forEach(l -> System.out.println("  " + l));

        System.out.println("\nEquality checks: ");
        System.out.println("l1/l2 same laptop" + l1.equals(l2));
        System.out.println("l1/l3 diff RAM" + l1.equals(l3));
        System.out.println("g1/g2 same gaming" + g1.equals(g2));
        System.out.println("g1/g3 diff Hz" + g1.equals(g3));
        System.out.println("l1-g1 laptop/Gaming" + l1.equals(g1));

        System.out.println("\nHashCode checks:");
        System.out.println("l1/l2 " + (l1.hashCode() == l2.hashCode()));
        System.out.println("g1/g2 " + (g1.hashCode() == g2.hashCode()));
        System.out.println("g1/g3 " + (g1.hashCode() == g3.hashCode()));
    }
}