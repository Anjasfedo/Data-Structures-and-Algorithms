package com.algorithms.string;

public class StringUtil {

    public static boolean isPalindrome(String words) {
        char[] charArr = words.toCharArray();
        int start = 0;
        int end = charArr.length - 1;

        while (start < end) {
            if (charArr[start] != charArr[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String words = "anjna";

        System.out.println(isPalindrome(words));
    }

}
