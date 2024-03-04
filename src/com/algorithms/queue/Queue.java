package com.algorithms.queue;

public class Queue {

    private ListNode front;

    private ListNode rear;

    private int length;

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

    public static void main(String[] args) {

    }
}
