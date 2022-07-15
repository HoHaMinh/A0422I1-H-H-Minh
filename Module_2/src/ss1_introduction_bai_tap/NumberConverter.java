package ss1_introduction_bai_tap;

import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        String[] numberToString1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] numberToString2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen"};
        String[] numberToString3 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your number");
        int number = Integer.parseInt(scanner.nextLine());
        if (number >= 0 && number < 10) {
            System.out.println(convertNumberLessThan10ToString(number, numberToString1));
        } else if (number < 16) {
            System.out.println(convertNumberLessThan16ToString(number, numberToString2));
        } else if (number < 20) {
            System.out.println(convertNumberLessThan20ToString(number, numberToString1));
        } else if (number < 100) {
            System.out.println(convertNumberLessThan100ToString(number, numberToString3, numberToString1));
        } else if (number < 1000) {
            int numberChecking1 = number / 100;
            int numberChecking2 = number % 100;
            String result;
            if (numberChecking2 == 0) {
                result = "";
            } else if (numberChecking2 < 10) {
                result = "and " + convertNumberLessThan10ToString(numberChecking2, numberToString1);
            } else if (numberChecking2 < 16) {
                result = "and " + convertNumberLessThan16ToString(numberChecking2, numberToString2);
            } else if (numberChecking2 < 20) {
                result = "and " + convertNumberLessThan20ToString(numberChecking2, numberToString1);
            } else {
                result = "and " + convertNumberLessThan100ToString(numberChecking2, numberToString3, numberToString1);
            }
            System.out.printf(
                    "%s hundred %s",
                    convertNumberLessThan10ToString(numberChecking1, numberToString1),
                    result
            );
        }
    }

    public static String convertNumberLessThan10ToString(int number, String[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (number == i) {
                result = array[i];
                break;
            }
        }
        return result;
    }

    public static String convertNumberLessThan16ToString(int number, String[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if ((number - 10) == i) {
                result = array[i];
            }
        }
        return result;
    }

    public static String convertNumberLessThan20ToString(int number, String[] array) {
        String result = "";
        for (int i = 6; i < array.length; i++) {
            if ((number - 10) == i) {
                result = array[i] + "teen";
                break;
            }
        }
        return result;
    }

    public static String convertNumberLessThan100ToString(int number, String[] array1, String[] array2) {
        String result = "";
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if ((number / 10) == (i + 2) && (number % 10) == j) {
                    if ((number % 10) == 0) {
                        result = array1[i];
                    } else {
                        result = array1[i] + " " + array2[j];
                    }
                }
            }
        }
        return result;
    }
}

