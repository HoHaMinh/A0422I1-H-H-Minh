package ss3_array_bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ElementOfArrayAdding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of array which you want: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        System.out.print("Please enter elements of array: ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Please enter the number you want to add: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the index which you want to add in: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index > array.length) {
            System.out.println("Cannot add the number into array");
        } else {
            for (int i = (array.length - 1); i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = number;
            System.out.println(Arrays.toString(array));
        }
    }
}
