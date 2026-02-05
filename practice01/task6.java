import java.util.Scanner;
public class task6 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String str= in.nextLine();
        String rev= "";
        for(int i=0;i<str.length();i++){
            rev = str.charAt(i)+rev;
        }

        if(rev.equals(str)){
            System.out.println("Palindrome!");
        }
        else{
            System.out.println("Not Palindrome!");
        }
    }
}
