package ss10_stack_queue.ss10_stack_queue_exercise;

import java.util.Scanner;
import java.util.Stack;

public class RevertStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Revert for int
//        Stack<Integer> stack = new Stack<>();
//        System.out.println("Please enter the length of array which you want: ");
//        int n = Integer.parseInt(scanner.nextLine());
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Please enter elements %d of array: \n", i);
//            array[i] = Integer.parseInt(scanner.nextLine());
//            stack.push(array[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            array[i] = stack.pop();
//        }
//        System.out.println("The new array after reverting: " + Arrays.toString(array));

//        Revert for String
        Stack<String> stack = new Stack<>();
        System.out.println("Please enter your word: ");
        String word = scanner.nextLine();
        String[] array = word.split("");
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        word = "";
        for (int i = 0; i < array.length; i++) {
            word += stack.pop();
        }
        System.out.println("The new array after reverting: " + word);
    }
}
