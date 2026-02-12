import java.util.Scanner;
public class Student {
    private String name;
    private int id;
    private int year;

    public Student(String name, int id){
            this.name = name;
            this.id = id;
            this.year = 1;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getCurrentYear() {
    return year;
    }

    public void incrementYear(){
        year++;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Your Name: ");
        String name = in.nextLine();
        System.out.println("Your ID:");
        int id = in.nextInt();

        Student k = new Student(name, id);
 
        // k.incrementYear();

        System.out.print(k.getName()+" study at KBTU. His/her ID number: " + k.getId() + 
        ". Current year of study: " + k.getCurrentYear());

    }
}
