package com.algorithms.array;

public class ArrayUtil {

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] removeEven(int[] arr) {
        int sumEven = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sumEven++;
            }
        }

        int[] result = new int[sumEven];
        int currI = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[currI] = arr[i];
                currI++;
            }
        }

        return result;
    }

    public static void reverseArray(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;

            start++;
            end--;
        }
    }

    public void arrayDemo() {
        // int[] myArray = new int[5]; // Initalize Array (will init with 0)

        // myArray[0] = 6;
        // myArray[1] = 2;
        // myArray[2] = 9;
        // myArray[3] = 4;
        // myArray[4] = 11;

        // myArray[2] = 8;

        // printArray(myArray);

        // System.out.println(myArray.length);

        // System.out.println(myArray[myArray.length - 1]);

        // System.out.println(" -------- ");

        int[] arr = { 4, 5, 1, 2, 7, 6, 10, 3 };

        printArray(removeEven(arr));

        // System.out.println(arr.length);

        // System.out.println(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        // ArrayUtil arrayUtil = new ArrayUtil();

        // arrayUtil.arrayDemo();

        int[] arr = { 4, 5, 1, 2, 7, 6, 10, 3, 3};

        reverseArray(arr, 0, arr.length - 1);

        printArray(arr);
    }
}