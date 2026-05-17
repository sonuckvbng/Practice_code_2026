package EvenOrOdd;

import java.util.Scanner;


public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integers to check if EVEN or ODD (enter -1 to exit):");

        int number;
        while ((number = scanner.nextInt()) != -1) {
            checkEvenOrOdd(number);
        }

        System.out.println("Program ended.");
        scanner.close();
    }

    static void checkEvenOrOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is an EVEN number.");
        } else {
            System.out.println(number + " is an ODD number.");
        }
    }
}


