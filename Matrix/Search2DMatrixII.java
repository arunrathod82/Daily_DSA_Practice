/*
Problem: Search a 2D Matrix II
Platform: LeetCode
Approach: Staircase Search (Top-Right Corner)
Time Complexity: O(m + n)
Space Complexity: O(1)

m = number of rows
n = number of columns
*/

import java.util.*;

public class Search2DMatrixII {

    public static boolean searchMatrix(
            int[][] matrix,
            int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;

        while(row < rows && col >= 0) {

            if(matrix[row][col] == target) {

                return true;
            }

            else if(matrix[row][col] > target) {

                // Move left
                col--;
            }

            else {

                // Move down
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        int target = 5;

        boolean result =
                searchMatrix(matrix, target);

        System.out.println(
                "Target Found: " + result
        );
    }
}