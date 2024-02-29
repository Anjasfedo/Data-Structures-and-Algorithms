package com.algorithms.array;

public class ArrayUtil {

    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {

    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
    }
}