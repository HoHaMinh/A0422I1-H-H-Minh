package ss12_search;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter the string: ");
        String string = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                } else break;
            }
            if (max.size() < list.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
            ;
        }
        for (Character ch : max) {
            System.out.println(ch);
        }
//        Tính toán độ phức tạp:
//        2 vòng lặp lồng nhau: n*(n-1)
//        1 câu lệnh if: 1
//        1 vòng lặp for each: n
//        Tổng: n*(n-1) + 1+ n=> T(n) =O(n^2)
    }
}
