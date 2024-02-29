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
        int[] myArray = new int[5]; // Initalize Array (will init with 0)

        myArray[0] = 6;
        myArray[1] = 2;
        myArray[2] = 9;
        myArray[3] = 4;
        myArray[4] = 11;

        myArray[2] = 8;

        printArray(myArray);

        System.out.println(myArray.length);

        System.out.println(myArray[myArray.length - 1]);

        System.out.println(" -------- ");

        int[] arr = {4,5,1,7};

        printArray(arr);

        System.out.println(arr.length);

        System.out.println(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();

        arrayUtil.arrayDemo();
    }
}