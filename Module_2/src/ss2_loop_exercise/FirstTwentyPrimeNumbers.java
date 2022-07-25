package ss2_loop_exercise;
public class FirstTwentyPrimeNumbers {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        int j = 2;
        while (count < 20) {
            while (i % j != 0) {
                j++;
            }
            if (i == j) {
                System.out.print(i + "\t");
                count++;
            }
            i++;
            j = 2;
        }
    }
}
