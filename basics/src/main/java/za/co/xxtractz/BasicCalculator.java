package za.co.xxtractz;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Step one -- prompt first number
        System.out.print("Enter first number::  ");
        double num1 = getsValidDoubleInput(scanner);
        // Step two -- prompt operator
        System.out.print("Enter operator::  ");
        char operator = getsValidOperator(scanner);
        // Step three -- prompt second number
        System.out.print("Enter second number::  ");
        double num2 = getsValidDoubleInput(scanner);
        // Step four -- calculate
        double result = performCal(num1,operator,num2);
        System.out.println("Result of "+num1 +" "+operator+" "+num2+ " ="+ result);
    }

    private static char getsValidOperator(Scanner scanner) {
        String input;
        while (true) {
            if (scanner.hasNext()){
                input = scanner.next();
                if (input.chars().count() <= 1)
                {
                    char operator = input.charAt(0);
                    if (operator == '+' ||
                            operator == '-' ||
                            operator == '*' ||
                            operator == '/' ||
                            operator == '%')
                    {
                        return operator;
                    }
                }
            }
            System.out.print("Invalid Operator, please try again::  ");
        }
    }

    private static double getsValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid number, please try again::  ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static double performCal(double num1, char operator, double num2) {
        switch (operator) {
            case '/':
                if (num2 == 0){
                    System.err.println("Error: Cannot divide by zero");
                    return 0;
                }
                return num1 / num2;
            case '*' :
                return num1 * num2;
            case '-' :
                return num1 - num2;
            case '+' :
                return num1 + num2;
            case '%' :
                return num1 % num2;
            default:
                System.err.println("invalid Operator");
                return 0;
        }
    }
}
