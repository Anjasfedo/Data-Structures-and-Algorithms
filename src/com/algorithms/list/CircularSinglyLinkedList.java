package com.algorithms.list;

public class CircularSinglyLinkedList {

    private ListNode last;

    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int listLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public ListNode createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        return first;
    }

    public void printElements() {
        if (last == null) {
            return;
        }

        ListNode first = last.next;

        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }

        System.out.print(first.data + " ");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.last = csll.createCircularLinkedList();

        csll.printElements();
    }
}
