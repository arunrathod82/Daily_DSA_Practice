/*
Problem: Convert 1D Array Into 2D Array
Platform: LeetCode
Approach: Matrix Traversal
Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/

import java.util.*;

public class Convert1DArrayInto2DArray {

    public static int[][] construct2DArray(
            int[] original,
            int m,
            int n) {

        // Impossible to construct
        if(original.length != m * n) {

            return new int[0][0];
        }

        int[][] result =
                new int[m][n];

        int index = 0;

        // Fill matrix row by row
        for(int row = 0;
            row < m;
            row++) {

            for(int col = 0;
                col < n;
                col++) {

                result[row][col] =
                        original[index++];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] original = {
                1,2,3,4
        };

        int m = 2;
        int n = 2;

        int[][] result =
                construct2DArray(
                        original,
                        m,
                        n
                );

        System.out.println(
                "Constructed 2D Array:"
        );

        for(int[] row : result) {

            System.out.println(
                    Arrays.toString(row)
            );
        }
    }
}