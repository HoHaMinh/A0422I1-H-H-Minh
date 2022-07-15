package ss2_loop_thuc_hanh;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter number b: ");
        int b = Integer.parseInt(scanner.nextLine());
        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (a == 0 && b == 0) {
            System.out.println("No result");
        } else if (b == 0) {
            System.out.println("Greatest common factor is: " + a);
        } else {
            if (a % b == 0) {
                System.out.println("Greatest common factor is: " + b);
            } else {
                System.out.println("Greatest common factor is: 1");
            }
        }
    }
}
