package za.co.xxtractz;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Who are you? ");

        String name = scanner.nextLine();
        System.out.println("My name is "+ name);
    }
}
