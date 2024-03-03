package com.algorithms.list;

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

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        } 
        ListNode temp = head.next;
        temp.prev = null;
        head = temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(5);
        dll.insertLast(7);

        dll.insertFirst(10);

        dll.deleteFirst();

        dll.printForward();
        dll.printBackward();
    }
}
