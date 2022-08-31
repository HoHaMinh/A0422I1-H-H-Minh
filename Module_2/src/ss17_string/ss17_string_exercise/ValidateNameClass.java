package ss17_string.ss17_string_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {
    public static void main(String[] args) {
        String test = "";
        System.out.println("Pls enter the name of class for checking: ");
        Scanner scanner = new Scanner(System.in);
        test = scanner.nextLine();
        final String CLASS_REGEX = "^[ACP][0-9]{4}[GHIKLM]$";
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(test);
        System.out.println("Input name of class is: " + matcher.matches());
    }
}
