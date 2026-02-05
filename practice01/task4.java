import java.util.Scanner;
public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a,b,c: ");
        double A = in.nextDouble();
        double B = in.nextDouble();
        double C = in.nextDouble();

        double D = B*B-4*A*C;
        if(D>0){
            Double X1 = (-B+Math.sqrt(D))/(2*A);
            Double X2 = (-B-Math.sqrt(D))/(2*A);
            System.out.println("Two roots. Answer: " + X1 +", "+X2);
        }
        else if(D==0){
            Double X = -(B/(2*A));
            System.out.println("One root. Answer: " + X);
        }
        else{
            System.out.println("D is negative. Can`t find roots.");
        }
    }    
}
