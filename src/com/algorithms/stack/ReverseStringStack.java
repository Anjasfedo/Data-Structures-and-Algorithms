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

    public static int[] nextGreaterReverse(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int check = 0;

        while (check < arr.length) {
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

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }

    public static boolean isValidParentheses(String strings) {
        Stack<Character> stack = new Stack<>();

        for (char c : strings.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();

                    if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // String name = "anjas";

        // System.out.println(name);

        // name = reverseString(name);

        // System.out.println(name);

        // int[] arr = { 4, 7, 3, 4, 8, 1 };

        // System.out.println(Arrays.toString(arr));

        // arr = nextGreaterElement(arr);

        // System.out.println(Arrays.toString(arr));

        String strings = "{()}";

        System.out.println(isValidParentheses(strings));
        System.out.println(strings);

        strings = reverseString(strings);
        
        System.out.println(isValidParentheses(strings));
        System.out.println(strings);
    }
}
