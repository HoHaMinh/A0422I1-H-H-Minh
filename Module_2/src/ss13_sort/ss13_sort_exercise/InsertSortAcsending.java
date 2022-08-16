package ss13_sort.ss13_sort_exercise;

import java.util.Scanner;

public class InsertSortAcsending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
        insertSortAcsending(list);
        System.out.println("List after sort: ");
        for (Integer item : list) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }

    public static void insertSortAcsending(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length; i++) {
            pos = i;
            x = list[i];
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
    }
}
