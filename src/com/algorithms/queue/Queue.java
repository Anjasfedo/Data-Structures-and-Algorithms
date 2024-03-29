package com.algorithms.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;

    private ListNode rear;

    private int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int listLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        int result = front.data;
        front = front.next;

        // Break the Queue
        if (front == null) {
            rear = null;
        }

        length--;
        return result;
    }

    public void printElements() {
        if (isEmpty()) {
            return;
        }

        ListNode curr = front;

        while (curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return front.data;
    }

    public int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return rear.data;
    }

    public static void generateBinaryNum(int num) {
        Queue queue = new Queue();

        for (int i = 1; i < num + 1; i++) {
            System.out.println(i);
            int dec = i;
            String bin = "";
            while (dec > 0) {
                int rem = dec % 2;
                queue.enqueue(rem == 0 ? 0 : 1);
                dec /= 2;
                bin += queue.dequeue();
            }

            System.out.println(bin);
        }

        // queue.printElements();
    }

    public static String[] generateBinaryNumbers(int n) {
        String[] result = new String[n];

        java.util.Queue<String> q = new LinkedList<>();

        q.offer("1");
        
        for (int i = 0; i < n; i++) {
            result[i] = q.poll();

            String n1 = result[i] + "0";
            String n2 = result[i] + "1";

            q.offer(n1);
            q.offer(n2);
        }

        return result;
    }

    public static void main(String[] args) {
        // Queue queue = new Queue();

        // queue.enqueue(2);
        // queue.enqueue(5);
        // System.out.println(queue.dequeue());
        // queue.enqueue(11);
        // System.out.println(queue.dequeue());
        // System.out.println(queue.dequeue());

        // queue.printElements();

        String[] binaryNumbers = generateBinaryNumbers(5);

        for (String string : binaryNumbers) {
            System.out.println(string);
        }
        
    }
}
