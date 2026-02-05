import java.util.Scanner;
import java.util.Locale;

public class task3 {
    public static void main(String args[]) {
        Scanner in = new Scanner (System.in);
        in.useLocale(Locale.US);
        System.out.println("Qansha aldynyz?");
        double baga = in.nextDouble();
        if(baga>=94.5){
            System.out.println("A");
        }
        else if(baga>=89.5){
            System.out.println("A-");
        }
        else if(baga>=84.5){
            System.out.println("B+");
        }
        else if(baga>=79.5){
            System.out.println("B");
        }
        else if(baga>=74.5){
            System.out.println("B-");
        }
        else if(baga>=69.5){
            System.out.println("C+");
        }
        else if(baga>=64.5){
            System.out.println("C");
        }
        else if(baga>=59.5){
            System.out.println("C-");
        }
        else if(baga>=54.5){
            System.out.println("D+");
        }
        else if(baga>=49.5){
            System.out.println("D");
        }
        else{
            System.out.println("F");
        }
    }
}
