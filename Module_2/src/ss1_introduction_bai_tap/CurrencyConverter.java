package ss1_introduction_bai_tap;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        double exchangeRate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your USD");
        double usd = Double.parseDouble(scanner.nextLine());
        double vnd = usd * exchangeRate;
        System.out.print("The value VND after exchanging is: " + vnd);
    }
}
