package com.algorithms.stack;

import java.util.EmptyStackException;

public class ReverseStringStack {
    private ListNode top;

    private int length;

    private class ListNode {
        private char data;
        private ListNode next;

        public ListNode(char data) {
            this.data = data;
        }
    }

    public ReverseStringStack() {
        top = null;
        length = 0;
    }

    public int stacklength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(char data) {
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

    public static String reverseString(String str) {
        ReverseStringStack stack = new ReverseStringStack();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            char data = stack.pop().data;
            chars[i] = data;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String name = "anjas";

        System.out.println(name);

        name = reverseString(name);

        System.out.println(name);
    }
}
