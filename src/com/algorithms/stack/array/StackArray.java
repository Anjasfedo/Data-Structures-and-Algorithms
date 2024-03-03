package com.algorithms.stack.array;

public class StackArray {

    private int top;

    private int[] arr;

    public StackArray(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == arr.length;
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Stack full");
        }

        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack empty");
        }

        int res = arr[top];
        arr[top] = 0;

        top--;

        return res;
    }

    public int peekTop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack empty");
        }

        return arr[top];
    }

    public static void main(String[] args) {
        StackArray sa = new StackArray(5);

        sa.push(3);
        sa.push(2);
        sa.push(3);
        sa.push(4);
        sa.push(5);

        sa.pop();
        sa.pop();

        System.out.println(sa.peekTop());
    }
}
