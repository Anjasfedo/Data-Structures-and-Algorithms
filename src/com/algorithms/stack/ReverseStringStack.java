package com.algorithms.stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStringStack {

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static int[] nextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int check = 0;

        while (check < arr.length) {
            // System.out.println(check);
            for (int i = check + 1; i < arr.length + 1; i++) {
                if (i == arr.length) {
                    stack.push(-1);
                    break;
                }

                if (arr[i] > arr[check]) {
                    stack.push(arr[i]);
                    break;
                }

            }
            check++;
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
        result[i] = stack.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        // String name = "anjas";

        // System.out.println(name);

        // name = reverseString(name);

        // System.out.println(name);

        int[] arr = { 4, 7, 3, 4, 8, 1 };

        System.out.println(Arrays.toString(arr));

        arr = nextGreater(arr);

        System.out.println(Arrays.toString(arr));

    }
}
