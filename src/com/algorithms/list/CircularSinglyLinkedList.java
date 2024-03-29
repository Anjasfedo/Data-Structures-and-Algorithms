package com.algorithms.list;

import java.util.NoSuchElementException;

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

        length += 4;

        return first;
    }

    public void printElements() {
        if (isEmpty()) {
            return;
        }

        ListNode first = last.next;

        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }

        System.out.print(first.data + " ");
        System.out.println();
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }

        last.next = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }

        last.next = newNode;
        last = newNode;
        length++;
    }

    public ListNode removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode first = last.next;

        if (last.next == last) {
            last = null;
        } else {
            last.next = first.next;
        }

        first.next = null;

        length--;

        return first;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.last = csll.createCircularLinkedList();

        csll.insertFirst(10);

        csll.insertLast(11);
        csll.insertLast(17);

        csll.printElements();

        System.out.println(csll.removeFirst().data);
        System.out.println(csll.removeFirst().data);
        System.out.println(csll.removeFirst().data);

        csll.printElements();
    }
}
