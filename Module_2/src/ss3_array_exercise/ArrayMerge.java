package ss3_array_exercise;

import java.util.Arrays;

public class ArrayMerge {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        int[] array3 = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = (array1.length); i < array3.length; i++) {
            array3[i] = array2[i - array1.length];
        }
        System.out.println(Arrays.toString(array3));
    }
}
