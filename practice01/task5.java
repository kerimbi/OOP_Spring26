import java.util.Scanner;
public class task5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Add Money: ");
        double money = in.nextDouble();
        System.out.println("Your Interest Rate: ");
        double rate = in.nextDouble();
        
        double percent = money * (rate/100);
        money += percent;
        System.out.println("Current balance: " + money);


        while(true){
            System.out.println("Do you wanna add more money? (1=yes / 2=no): ");
            int a = in.nextInt();

            if(a==1){
                System.out.print("Enter amount: ");
                double tagy = in.nextDouble();
                money += tagy + tagy*(rate/100);
                System.out.println("Current balance: " + money);
            }
            else if(a == 2){
                System.out.println("Final balance: " + money);
                break;
            }
            else{
                System.out.println("Invalid input! enter 1 or 2");
            }
        }
        
           
    }
}