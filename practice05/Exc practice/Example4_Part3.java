    import java.util.*;

    public class Example4_Part3
    {
        public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);

            System.out.println("Enter expressions (blank line to quit):");

            String line;
            while (!(line = in.nextLine()).isEmpty())
            {
                StringTokenizer tokenizer = new StringTokenizer(line, "+-*/", true);

                while (tokenizer.hasMoreTokens())
                {
                    String leftString, operator, rightString;

                    try
                    {
                        leftString  = tokenizer.nextToken().trim();
                        operator    = tokenizer.nextToken().trim();
                        rightString = tokenizer.nextToken().trim();
                    }
                    catch (NoSuchElementException nsee)
                    {
                        System.out.println("Invalid syntax");
                        break;
                    }

                    double leftOperand  = 0;
                    double rightOperand = 0;

                    try
                    {
                        leftOperand = Double.parseDouble(leftString);
                    }
                    catch (NumberFormatException nfe)
                    {
                        System.out.println("Left operand '" + leftString + "' is not a number");
                        continue;
                    }

                    try
                    {
                        rightOperand = Double.parseDouble(rightString);
                    }
                    catch (NumberFormatException nfe)
                    {
                        System.out.println("Right operand '" + rightString + "' is not a number");
                        continue;
                    }

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
            }
        }
    }