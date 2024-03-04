package com.algorithms.queue;

import java.util.NoSuchElementException;

import org.w3c.dom.ls.LSInput;

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
            throw new NoSuchElementException();
        }

        int result = front.data;
        front = front.next;

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

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(2);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.enqueue(11);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.printElements();
        ;
    }
}
