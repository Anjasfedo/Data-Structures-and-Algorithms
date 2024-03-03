package com.algorithms.stack.list;

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

    public void push(int data) {
        ListNode newNode = new ListNode(data);

        top.next = newNode;
        top = newNode;

        length++;
    }

    public ListNode pop() {
        ListNode temp = top;

        top = top.next;

        length--;
        
        return temp;
    }

    public static void main(String[] args) {
        StackList sl = new StackList();

        
    }
}
