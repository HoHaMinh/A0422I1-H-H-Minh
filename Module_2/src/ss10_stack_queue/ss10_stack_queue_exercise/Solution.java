package ss10_stack_queue.ss10_stack_queue_exercise;

public class Solution {
    static class Node {
        int data;
        Node link;
    }

    static class Queue {
        Node front, rear;
    }

    static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null) {
            q.front = temp;
        } else {
            q.rear.link = temp;}
            q.rear=temp;
            q.rear.link = q.front;
        }

    static void deQueue(Queue q) {
        if (q.front == null) {
            System.out.println("Queue is empty");
        }
        if (q.front == q.rear) {
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            q.front = q.front.link;
            q.rear.link = q.front;
        }
    }

    static void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.println("Elements in Queue are: ");
        while (temp.link != q.front) {
            System.out.printf("%d \n", temp.data);
            temp = temp.link;
        }System.out.printf("%d \n", temp.data);
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = q.rear = null;
        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);
        displayQueue(q);
        deQueue(q);
        displayQueue(q);
        enQueue(q, 9);
        enQueue(q, 20);
        displayQueue(q);
    }
}
