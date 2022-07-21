package ss4_class_bai_tap.ss4_class_bai_tap_watch;

public class ClassStopWatch {
    public static void main(String[] args) {
        StopWatch time = new StopWatch();
        time.start();
        sort(100000);
        time.stop();
        System.out.println(time.getElapsedTime());
    }

    public static void sort(int number) {
        double[] arr = new double[number];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 1000;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}
