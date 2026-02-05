import java.util.Scanner;
public class task1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.print("+");
        for (int i = 0; i < name.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");

        System.out.println("|" + name + "|");

        System.out.print("+");
        for (int i = 0; i < name.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");

        
    }
    
}
