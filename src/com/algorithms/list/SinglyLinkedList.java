package com.algorithms.list;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printElements() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");

        System.out.println();
    }

    public int FindLength() {
        int count = 0;
        ListNode curNode = head;

        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        return count;
    }

    public void InsertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void InsertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = newNode;
    }

    public void InsertPosition(int data, int position) {
        ListNode newNode = new ListNode(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode prevNode = head;
            int count = 1;

            while (count < position - 1) {
                prevNode = prevNode.next;
                count++;
            }

            ListNode curNode = prevNode.next;
            newNode.next = curNode;
            prevNode.next = newNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // sll.head = new ListNode(10);

        // ListNode second = new ListNode(1);
        // ListNode third = new ListNode(8);
        // ListNode fourth = new ListNode(11);

        // // Connect pointer
        // sll.head.next = second;
        // second.next = third;
        // third.next = fourth;

        // sll.InsertFirst(15);
        // sll.InsertFirst(17);
        // sll.InsertFirst(2);
        // sll.InsertFirst(5);
        // sll.InsertLast(5);
        // sll.InsertLast(5);
        // sll.InsertLast(5);
        // sll.InsertLast(5);

        sll.InsertPosition(5, 1);
        sll.InsertPosition(7, 2);
        sll.InsertPosition(7, 2);
        sll.InsertPosition(7, 2);
        sll.InsertPosition(7, 2);
        
        // Print Singly Linked List Elements
        sll.printElements();

        // Find the Length
        // System.out.println(sll.FindLength());
    }
}
