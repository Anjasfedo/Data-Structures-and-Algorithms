package com.algorithms.stack.list;

import java.util.EmptyStackException;
import java.util.Stack;

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

    public boolean isPalindrome() {
        Stack<Integer> stack = new Stack<>();

        ListNode curNode = top;

        while (curNode.next != null) {
            if (curNode.data < curNode.next.data) {
                stack.push(curNode.data);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    int top = stack.peek();

                    if (curNode.next.data == top) {
                        stack.pop();
                    }
                }
            }

            curNode = curNode.next;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackList sl = new StackList();

        sl.push(2);
        sl.push(5);
        // sl.push(5);
        // sl.push(2);
        // sl.push(5);
        // sl.push(2);

        // sl.printElements();

        System.out.println(sl.isPalindrome());
    }
}
