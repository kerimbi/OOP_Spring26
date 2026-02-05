import java.util.Scanner;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second){
        //if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            //System.out.println("Invalid input!Range must be: hour(0-23), minute(0-59), second(0-59).");} 
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public static boolean isValid(int hour, int minute, int second){
        return hour>=0 && hour<=23 && minute>=0 && minute<=59 && second>=0 && second<=59;}

    public String toUniversal(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toStandard(){
        String m = "AM";
        if(hour>=12){
            m = "PM";
        }
        int actualHour = hour;
        if(hour==0){
            actualHour=12;
        }
        else if(hour>12){
            actualHour=hour-12;
        }
        else if(hour==12){
            actualHour=12;
        }
        return String.format("%02d:%02d:%02d %s", actualHour, minute, second, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hour, minute, second;

        while (true) { 
            System.out.println("Enter time:");
            hour=in.nextInt();
            minute=in.nextInt();
            second=in.nextInt();
        
            if (isValid(hour, minute, second)){
                  break;
            }
            System.out.println("Invalid input!Range must be: hour(0-23), minute(0-59), second(0-59).");
        }   

        Time t = new Time(hour,minute,second);
        System.out.println(t.toUniversal());// prints "23:05:06"
        System.out.println(t.toStandard());//prints "11:05:06 PM"
        
    }
}

