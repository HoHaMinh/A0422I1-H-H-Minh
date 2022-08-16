package ss13_sort.ss13_sort_practice;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        selectionSort(list);
        for (Double item : list) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            double max = list[i];
            int indexMax = i;
            for (int j = i+1; j < list.length; j++) {
                if (max < list[j]) {
                    max = list[j];
                    indexMax = j;
                }
            }
            list[indexMax] = list[i];
            list[i] = max;
        }
    }
}
