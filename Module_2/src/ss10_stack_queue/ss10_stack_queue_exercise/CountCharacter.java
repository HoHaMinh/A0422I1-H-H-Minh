package ss10_stack_queue.ss10_stack_queue_exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter your string: ");
        String st = scanner.nextLine();
        Map map = count(st);
        Set<Character> keys = map.keySet();
        for (Character c : keys) {
            System.out.println(c + ": " + map.get(c) + " times");
        }
    }

    public static Map<Character, Integer> count(String st) {
        Map<Character, Integer> map = new HashMap<>();
        st = st.toLowerCase();
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        return map;
    }
}
