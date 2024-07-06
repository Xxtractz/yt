package za.co.xxtractz;

import java.util.Scanner;
import java.util.Set;

public class BasicCalculator {
    private static final  char PLUS = '+';
    private static final char MULTIPLY = '*';
    private static final  char DIVIDE = '/';
    private static final  char  MODULUS = '%';
    private static final  char MINUS = '-';

    private static final Set<Character> VALID_OPERATORS = Set.of(PLUS,MULTIPLY,DIVIDE,MODULUS,MINUS);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = promptForDouble("Enter first number::  ",scanner);
        char operator = promptOperator(scanner);
        double num2 = promptForDouble("Enter second number::  ",scanner);

        double result = performCal(num1,operator,num2);
        displayResults(num1,num2,operator,result);
    }

    private static double promptForDouble(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()){
                return scanner.nextDouble();
            }else {
                System.out.print("Invalid number, please try again::  ");
                scanner.next();
            }
        }
    }

    private static char promptOperator(Scanner scanner) {
        while (true){
            System.out.print("Enter Operator (+, -, *, / ,%) : ");
            String input = scanner.nextLine().trim();

            if (isValidOperator(input)){
                return input.charAt(0);
            }
            System.out.println("Invalid operator, please try again::  ");
        }
    }

    private static boolean isValidOperator(String input){
        return input.length() == 1 && VALID_OPERATORS.contains(input.charAt(0));
    }

    private static double performCal(double num1, char operator, double num2) {
        switch (operator) {
            case DIVIDE:
                if (num2 == 0){
                    System.err.println("Error: Cannot divide by zero");
                    return Double.NaN;
                }
                return num1 / num2;
            case MULTIPLY :
                return num1 * num2;
            case MINUS :
                return num1 - num2;
            case PLUS:
                return num1 + num2;
            case MODULUS :
                return num1 % num2;
            default:
                throw new IllegalArgumentException("Invalid operator" + operator);
        }
    }

    private static void displayResults(double num1, double num2, char operator, double result){
        if (Double.isNaN(result)){
            System.err.printf("Cannot perform Calculation %f %c %f due to an error.%n",num1,operator,num2);
        }else {
            System.out.printf("Result of  %f %c %f = %f  %n",num1,operator,num2, result);
        }
    }
}
