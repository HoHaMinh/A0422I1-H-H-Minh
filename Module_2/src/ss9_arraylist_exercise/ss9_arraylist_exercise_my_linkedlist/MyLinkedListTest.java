package ss9_arraylist_exercise.ss9_arraylist_exercise_my_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.addFirst(2);
        test.addLast(4);
        test.addFirst(3);
        test.add(2,10);
        test.add(null);
//        test.clear();
//        test.remove(2);
        MyLinkedList test2 = test.clone();
        test.printList();
        test2.printList();
//        System.out.println(test.indexOf(null));
//        System.out.println(test.getLast());
    }
}
