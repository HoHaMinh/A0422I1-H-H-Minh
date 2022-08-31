package ss17_string.ss17_string_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTel {
    public static void main(String[] args) {
        final String TEL_REGEX = "^[0-9]{2}-0\\d{9}$";
        String tel = "";
        System.out.println("Pls enter your tel number for checking: ");
        Scanner scanner = new Scanner(System.in);
        tel = scanner.nextLine();
        Pattern pattern = Pattern.compile(TEL_REGEX);
        Matcher matcher = pattern.matcher(tel);
        System.out.println("The input tel is: " + matcher.matches());
    }
}
