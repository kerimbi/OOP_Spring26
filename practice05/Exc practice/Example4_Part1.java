import java.util.*;

public class Example4_Part1
{
    public static void main(String[] args)
    {
        double          leftOperand, result = 0, rightOperand;
        String          leftString, operator, rightString;
        StringTokenizer tokenizer;
        Scanner in = new Scanner(System.in);

        tokenizer = new StringTokenizer(in.nextLine(), "+-*/", true);

        try
        {
            leftString  = tokenizer.nextToken();
            operator    = tokenizer.nextToken();
            rightString = tokenizer.nextToken();

            leftOperand  = Double.parseDouble(leftString);
            rightOperand = Double.parseDouble(rightString);

            if      (operator.equals("+")) result = leftOperand + rightOperand;
            else if (operator.equals("-")) result = leftOperand - rightOperand;
            else if (operator.equals("*")) result = leftOperand * rightOperand;
            else if (operator.equals("/"))
            {
                if (rightOperand == 0)
                {
                    System.out.println("Error: division by zero");
                    return;
                }
                result = leftOperand / rightOperand;
            }
            else
            {
                System.out.println("Unknown operator: " + operator);
                return;
            }

            System.out.println("Result: " + result);
        }
        catch (NoSuchElementException nsee)
        {
            System.out.println("Invalid syntax");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("One or more operands is not a number");
        }
    }
}