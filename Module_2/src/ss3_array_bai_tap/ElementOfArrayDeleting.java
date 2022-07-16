package ss3_array_bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ElementOfArrayDeleting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of array which you want: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        System.out.print("Please enter elements of array: \t");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Please input the number you want to delete: ");
        int number = Integer.parseInt(scanner.nextLine());
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                index = i;
                break;
            }
        }
        for (int i = index; i < (array.length - 1); i++) {
            array[i] = array[i + 1];
        }
        System.out.print(Arrays.toString(array));
    }
}
