class Animals {
    protected String name;
    protected int age;
    
    public Animals(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void makeSound(){
        System.out.println(name+ "makes a some sound.");
    }
    public void eatFood(){
        System.out.println(name+ "eat something.");
    }
    public void moving(){
        System.out.println(name+ "make some moves.");
    }

    public void displayInfo(){
        System.out.println("Name of animal: "+name);
        System.out.println("Age: "+age);
    }
}

enum HorseAgeTypes{
    Qulyn, Zhabagy, Tay, Qunan, Donen, Besti, Bie, Ayghyr
}
enum HorseUsePurpose{
    Minis, Zhegu, Sporttyk, Etsutke
}

class Horse extends Animals{
    private String color;
    private HorseAgeTypes agetype;
    private HorseUsePurpose purpose;

    public Horse(String name, int age, String color, HorseAgeTypes agetype, HorseUsePurpose purpose){
        super(name,age);
        this.color = color;
        this.agetype = agetype;
        this.purpose = purpose;
    }

    @Override
    public void makeSound(){
        System.out.println(name+ " sounds IGOGOGO!");
    }

    @Override
    public void eatFood(){
        System.out.println(name+ " eat hay, oat");
    }

    @Override
    public void moving(){
        System.out.println(name+ " gallops");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Color " + color);

    switch (agetype) {
        case Qulyn:    System.out.println("Qulyn (from birth)");      break;
        case Zhabagy: System.out.println("Zhabaghy (6 months old)"); break;
        case Tay:      System.out.println("Tay (1 year old)");        break;
        case Qunan:    System.out.println("Qunan (2 years old)");     break;
        case Donen:    System.out.println("Donen (3 years old)");     break;
        case Besti:    System.out.println("Besti (4+ years)");        break;
        case Bie:      System.out.println("Bie (female)");     break;
        case Ayghyr:   System.out.println("Ayghyr (male)"); break;
        }

    switch (purpose) {
        case Minis:    System.out.println("Minis zhylqysy");         break;
        case Zhegu:    System.out.println("Zhegu zhylqysy");           break;
        case Sporttyk: System.out.println("Sporttyk zhylqy");          break;
        case Etsutke:   System.out.println("Et-sut baghytynda");  break;
        }
    }


    public void race(){
        System.out.println(name+" is racing.");
    }
    public void race(int distance){
        System.out.println(name+" is racing "+distance+" km.");
    }
    public void race(int distance, String opponent){
        System.out.println(name+" is racing "+distance+" km against "+opponent);
    }
}

public class Animal{
    public static void main(String[] args) {
        System.out.println("Main info: ");
        Horse horse = new Horse("Tulpar", 5, "Black", HorseAgeTypes.Besti, HorseUsePurpose.Sporttyk);
        horse.displayInfo();
        horse.makeSound();
        horse.eatFood();
        horse.moving();

        System.out.println("");
        System.out.println("Zharys:");
        horse.race();
        horse.race(15);
        horse.race(20, "Aqboz");
    }
}
