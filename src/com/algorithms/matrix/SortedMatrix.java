package com.algorithms.matrix;

public class SortedMatrix {
    
    public void search(int[][] matrix, int length, int target) {
        int i = 0;
        int j = length - 1;

        while (i < length && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println("Found at - " + i + ", " + j);
                return;
            }

            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Not found");
    }

    public static void main(String[] args) {
        int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 51 } };

        SortedMatrix sm = new SortedMatrix();

        sm.search(matrix, matrix.length, 37);
        sm.search(matrix, matrix.length, 17);
    }
}
