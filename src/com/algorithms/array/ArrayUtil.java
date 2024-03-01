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

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secMax = max;
                max = arr[i];
            } else if (arr[i] > secMax && arr[i] != max) {
                secMax = arr[i];
            }
        }

        return secMax;
    }

    public static int[] moveZeroToEnd(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            if (arr[j] != 0) {
                j++;
            }
        }

        return arr;
    }

    public static int[] resizeArray(int[] arr, int capacity) {
        int[] temp = new int[capacity];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        return temp;
    }

    public static int findMissingNum(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;

        for (int num : arr) {
            sum -= num;
        }

        return sum;
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

        int[] arr = { 2, 4, 1, 8, 6, 3, 7 };

        // reverseArray(arr, 0, arr.length - 1);

        // printArray(arr);

        // System.out.println(findMin(arr));

        // System.out.println(findSecondMax(arr));

        // printArray(moveZeroToEnd(arr));

        // printArray(arr);

        // arr = resizeArray(arr, 10);

        // printArray(arr);

        System.out.println(findMissingNum(arr));
    }
}