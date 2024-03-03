package com.algorithms.stack.list;

import java.util.EmptyStackException;

public class StackList {

    private ListNode top;
    
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public StackList() {
        top = null;
        length = 0;
    }

    public int stacklength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);

        newNode.next = top;
        top = newNode;

        length++;
    }

    public ListNode pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        ListNode temp = top;

        top = top.next;

        length--;

        return temp;
    }

    public int peekTop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public void printElements() {
        ListNode temp = top;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        StackList sl = new StackList();

        sl.push(5);
        sl.push(5);
        sl.push(2);
        sl.pop();
        sl.push(4);
        sl.push(7);
        sl.pop();

        sl.printElements();
    }
}
