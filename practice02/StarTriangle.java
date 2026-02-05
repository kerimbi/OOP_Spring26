import java.util.Scanner;
public class StarTriangle {
    private int width;

    public StarTriangle(int width){
        this.width=width;
    }

    public void printTriangle(){
        for (int i = 0; i <width; i++) {
            for(int j=0; j<=i; j++){
                System.out.print("[*]");
            }
            System.out.println();
        }
    }

    public String toString(){
        String ans="";
        for (int i=0; i<width; i++) {
            for(int j=0; j<=i; j++){
                ans+="[*]";
            }
            ans+="\n";
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Width: ");
        int width= in.nextInt();
        
        StarTriangle small = new StarTriangle(width);
        System.out.println("With System out: ");
        small.printTriangle();

        System.out.println("With toString: ");
        System.out.print(small.toString());
    }   
}
