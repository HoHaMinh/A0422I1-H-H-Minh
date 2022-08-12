package ss9_arraylist_exercise.ss9_arraylist_exercise_my_linkedlist;

import java.util.Objects;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        if (numNodes <= index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Wrong Index");
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        numNodes++;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(element);
        numNodes++;
        newNode.next = null;
        temp.next = newNode;
    }

    public E remove(int index) {
        if (numNodes <= index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Wrong Index");
        }
        Node temp = head;
        if (index == 0) {
            head = temp.next;
            numNodes--;
            return (E) temp.getData();
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        E value = (E) temp.next.getData();
        temp.next = temp.next.next;
        numNodes--;
        return value;
    }

    public boolean remove(E e) {
        Node temp = head;
        if (Objects.equals(temp.data, e)) {
            head = temp.next;
            numNodes--;
            return true;
        }
        while (temp.next != null) {
            if (Objects.equals(temp.data, e)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E e) {
        Node temp = head;
        while (temp != null) {
            if (Objects.equals(temp.data, e)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (Objects.equals(temp.getData(), e)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e) {
        if (head == null) {
            addFirst(e);
        } else {
            addLast(e);
        }
        return true;
    }

    public E get(int index) {
        if (numNodes <= index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Wrong Index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {
        head = new Node() ;
        head.next = null;
    }

    public MyLinkedList clone () {
        MyLinkedList newList = new MyLinkedList();
        newList.numNodes = this.numNodes;
        Node temp = head;
        Node newNode = null;
        for(int i = 0; i < numNodes; i++) {
            if (i == 0) {
                newNode = new Node(temp.data);
                newList.head = newNode;
            } else {
                newNode.next = new Node(temp.data);
                newNode = newNode.next;
            }
            temp = temp.next;
        }
        return newList;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    class Node {
        Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node() {
        }

        public Object getData() {
            return this.data;
        }
    }
}
