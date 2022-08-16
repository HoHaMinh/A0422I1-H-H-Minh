package ss13_sort.ss13_sort_practice;

public class BubleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
        bubleSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " ");
        }
    }

    public static void bubleSort(int[] list) {
        boolean next = true;
        for (int i = 0; i < list.length && next; i++) {
            next = false;
            for (int j = list.length - 1; j >= i; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    next = true;
                }
            }
        }
    }
}
