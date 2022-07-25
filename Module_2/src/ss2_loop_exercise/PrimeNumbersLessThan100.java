package ss2_loop_exercise;

public class PrimeNumbersLessThan100 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            int j = 2;
            while (i % j != 0) {
                j++;
            }
            if (i == j) {
                System.out.print(i + "\t");
            }
        }
    }
}
