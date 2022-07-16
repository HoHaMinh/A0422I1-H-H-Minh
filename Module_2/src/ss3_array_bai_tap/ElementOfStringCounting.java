package ss3_array_bai_tap;

import java.util.Scanner;

public class ElementOfStringCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the string: ");
        String string = scanner.nextLine();
        System.out.println("Please enter the word you want to count: ");
        char character1 = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char character2 = string.charAt(i);
            if (character1 == character2) {
                count++;
            }
        }
        System.out.printf("Character %c is shown by %d times", character1, count);
    }
}
