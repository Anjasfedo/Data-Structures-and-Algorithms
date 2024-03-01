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
        ListNode curListNode = head;

        while (curListNode != null) {
            count++;
            curListNode = curListNode.next;
        }
        return count;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.head = new ListNode(10);

        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // Connect pointer
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        // Print Singly Linked List Elements
        sll.printElements();

        // Find the Length
        System.out.println(sll.FindLength());
    }
}
