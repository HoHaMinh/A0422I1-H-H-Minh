package ss2_loop_practice;

import java.util.Scanner;

public class PrimeNumberChecking {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Please input number: ");
        int number = Integer.parseInt(inputNumber.nextLine());
        boolean check = true;
        if (number < 2) {
            check = false;
        } else if (number == 2) {
            check = true;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("Input number is prime number");
        } else {
            System.out.println("Input number is not prime number");
        }
    }
}
