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

    public static void main(String[] args) {
        
    }
}
