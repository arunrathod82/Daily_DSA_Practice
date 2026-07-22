/*
Problem: Spiral Matrix II
Platform: LeetCode
Approach: Boundary Traversal (Spiral Filling)
Time Complexity: O(n²)
Space Complexity: O(1) (excluding the output matrix)

n = size of the square matrix
*/

import java.util.*;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {

        int rows = n;
        int cols = n;

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = rows - 1;

        int left = 0;
        int right = cols - 1;

        int num = 1;

        while(top <= bottom && left <= right) {

            // Fill Left → Right
            for(int col = left;
                col <= right;
                col++) {

                matrix[top][col] = num++;
            }

            top++;

            // Fill Top → Bottom
            for(int row = top;
                row <= bottom;
                row++) {

                matrix[row][right] = num++;
            }

            right--;

            // Fill Right → Left
            if(top <= bottom) {

                for(int col = right;
                    col >= left;
                    col--) {

                    matrix[bottom][col] = num++;
                }

                bottom--;
            }

            // Fill Bottom → Top
            if(left <= right) {

                for(int row = bottom;
                    row >= top;
                    row--) {

                    matrix[row][left] = num++;
                }

                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] result = generateMatrix(n);

        System.out.println("Generated Spiral Matrix:");

        for(int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}