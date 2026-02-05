import java.util.Scanner;

public class task2{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your size of side:");
        int a = in.nextInt();
         a= Integer.MAX_VALUE;
        int area = a*a; 
        int perimeter = a*4;
        double diagonal = Math.sqrt(2)*a;
        
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " +perimeter);
        System.out.println("Diagonal: " + diagonal);
        
    }
}