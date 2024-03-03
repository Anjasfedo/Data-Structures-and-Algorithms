package com.algorithms.stack;

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

    public static void main(String[] args) {
        String name = "anjas";

        System.out.println(name);

        name = reverseString(name);

        System.out.println(name);
    }
}
