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

    public static void main(String[] args) {
        
    }
}
