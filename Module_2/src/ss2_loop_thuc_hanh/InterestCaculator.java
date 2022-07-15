package ss2_loop_thuc_hanh;

import java.util.Scanner;

public class InterestCaculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your money: ");
        double money = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input the months you want to borrow money: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input interest rate: ");
        double interestRate = Double.parseDouble(scanner.nextLine());
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate / 100) / 12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
