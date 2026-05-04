public class Example1
{
    public static void main(String[] args)
    {
        int denominator, numerator, ratio;

        numerator   = 5;
        denominator = 0;

        try
        {
            ratio = numerator / denominator;
            System.out.println("The answer is: " + ratio);
        }
        catch (ArithmeticException ae)
        {
            System.out.println("Divide by 0.");
            ae.printStackTrace();
        }

        System.out.println("Done.");
    }
}

    Comparator <STudent> compareStudent = (s1,s2)
int Comp = Double.compare(d2.gpa, d1.gpa)
if (Comp!=0) return Comp
return d1.name.compareTo(d2.name)
