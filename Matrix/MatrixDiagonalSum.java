/*
Problem: Matrix Diagonal Sum
Platform: LeetCode
Approach: Matrix Traversal
Time Complexity: O(n)
Space Complexity: O(1)

n = number of rows (or columns)
*/

import java.util.*;

public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {

        int sum = 0;
        int n = mat.length;

        // Add Primary and Secondary Diagonal
        for(int i = 0;
            i < n;
            i++) {

            sum += mat[i][i];             // Primary diagonal
            sum += mat[i][n - 1 - i];     // Secondary diagonal
        }

        // Subtract the middle element once
        // because it is counted twice
        if(n % 2 != 0) {

            int mid = n / 2;

            sum -= mat[mid][mid];
        }

        return sum;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int result = diagonalSum(mat);

        System.out.println(
                "Diagonal Sum: " + result
        );
    }
}