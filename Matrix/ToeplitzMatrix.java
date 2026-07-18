/*
Problem: Toeplitz Matrix
Platform: LeetCode
Approach: Matrix Traversal
Time Complexity: O(m × n)
Space Complexity: O(1)

m = number of rows
n = number of columns
*/

import java.util.*;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(
            int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Compare each element with its
        // bottom-right diagonal element
        for(int row = 0;
            row < rows - 1;
            row++) {

            for(int col = 0;
                col < cols - 1;
                col++) {

                if(matrix[row][col] !=
                   matrix[row + 1][col + 1]) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };

        boolean result =
                isToeplitzMatrix(matrix);

        System.out.println(
                "Is Toeplitz Matrix: "
                + result
        );
    }
}