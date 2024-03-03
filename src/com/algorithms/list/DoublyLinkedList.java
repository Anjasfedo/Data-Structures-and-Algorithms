package com.algorithms.list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;

    private ListNode tail;

    private int length;

    private class ListNode {
        private int data;
        private ListNode prev;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0; // head == null
    }

    public int listLength() {
        return length;
    }

    public void printForward() {
        if (isEmpty()) {
            return;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public void printBackward() {
        if (isEmpty()) {
            return;
        }

        ListNode temp = tail;

        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.prev;
        }

        System.out.print("null");
        System.out.println();
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = head;

        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }

        head = head.next;
        temp.next = null;

        return temp;
    }
    
    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = tail;

        if (head == tail) {
            head = null;
        } else {
            tail.prev.next = null;
        }

        tail = tail.prev;
        temp.prev = null;

        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(5);
        dll.insertLast(7);

        dll.insertFirst(10);

        System.out.println(dll.deleteFirst().data);
        System.out.println(dll.deleteLast().data);

        dll.printForward();
        dll.printBackward();
    }
}
