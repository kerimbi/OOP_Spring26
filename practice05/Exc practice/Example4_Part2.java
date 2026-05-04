import java.util.*;

public class Example4_Part2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter expressions (blank line to quit):");

        String line;
        while (!(line = in.nextLine()).isEmpty())
        {
            String[] expressions = line.trim().split("\\s+");

            for (String expr : expressions)
            {
                StringTokenizer tokenizer = new StringTokenizer(expr, "+-*/", true);

                try
                {
                    String leftString  = tokenizer.nextToken().trim();
                    String operator    = tokenizer.nextToken().trim();
                    String rightString = tokenizer.nextToken().trim();

                    double leftOperand  = Double.parseDouble(leftString);
                    double rightOperand = Double.parseDouble(rightString);
                    double result = 0;

                    if      (operator.equals("+")) result = leftOperand + rightOperand;
                    else if (operator.equals("-")) result = leftOperand - rightOperand;
                    else if (operator.equals("*")) result = leftOperand * rightOperand;
                    else if (operator.equals("/"))
                    {
                        if (rightOperand == 0)
                        {
                            System.out.println("Error: division by zero");
                            continue;
                        }
                        result = leftOperand / rightOperand;
                    }
                    else
                    {
                        System.out.println("Unknown operator: " + operator);
                        continue;
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
    }
}