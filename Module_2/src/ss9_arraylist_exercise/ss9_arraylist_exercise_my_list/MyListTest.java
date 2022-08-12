package ss9_arraylist_exercise.ss9_arraylist_exercise_my_list;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myListInterger = new MyList<>();
        myListInterger.add(2, 5);
        myListInterger.add(3);
        for (int i = 0; i < myListInterger.getSize(); i++) {
            System.out.println(myListInterger.get(i));
        }
//        System.out.println(myListInterger.contains(5));
//        System.out.println(myListInterger.indexOf(5));
//        System.out.println(myListInterger.add(3));
////        myListInterger.clear();
//        for (int i = 0; i < myListInterger.getSize(); i++) {
//            System.out.println(myListInterger.get(i));
//        }
        MyList test = myListInterger.clone();
        for (int i = 0; i < test.getSize(); i++) {
            System.out.println(test.get(i));
        }
    }
}
