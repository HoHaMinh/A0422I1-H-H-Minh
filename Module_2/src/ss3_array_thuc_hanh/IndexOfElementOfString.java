package ss3_array_thuc_hanh;

import java.util.Scanner;

public class IndexOfElementOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numbers of students which you want to input: ");
        int n = Integer.parseInt(scanner.nextLine());
        String[] array = new String[n];
        System.out.println("Please enter names of students: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLine();
        }
        System.out.println("Please enter the name of student you want to find position");
        String name = scanner.nextLine();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(name)) {
                index = i + 1;
            }
        }
        System.out.printf("The position of the name %s is %d", name, index);
    }
}
