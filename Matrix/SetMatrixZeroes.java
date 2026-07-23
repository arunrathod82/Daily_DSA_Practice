/*
Problem: Set Matrix Zeroes
Platform: LeetCode
Approach: Row & Column Marking (Using Extra Arrays)
Time Complexity: O(m × n)
Space Complexity: O(m + n)

m = number of rows
n = number of columns
*/

import java.util.*;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Store rows and columns
        // that contain zero
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        // First Pass:
        // Mark rows and columns
        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(matrix[i][j] == 0) {

                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Second Pass:
        // Set elements to zero
        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(row[i] || col[j]) {

                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        setZeroes(matrix);

        System.out.println("Matrix After Setting Zeroes:");

        for(int[] row : matrix) {

            System.out.println(Arrays.toString(row));
        }
    }
}