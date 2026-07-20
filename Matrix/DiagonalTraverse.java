/*
Problem: Diagonal Traverse
Platform: LeetCode
Approach: Simulation (Diagonal Traversal)
Time Complexity: O(m × n)
Space Complexity: O(1) (excluding the output array)

m = number of rows
n = number of columns
*/

import java.util.*;

public class DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];

        int row = 0;
        int col = 0;

        // true = moving up-right
        // false = moving down-left
        boolean up = true;

        for(int i = 0; i < rows * cols; i++) {

            result[i] = mat[row][col];

            if(up) {

                row--;
                col++;

                // Hit the right boundary
                if(col == cols) {

                    col = cols - 1;
                    row += 2;
                    up = false;
                }

                // Hit the top boundary
                else if(row < 0) {

                    row = 0;
                    up = false;
                }

            } else {

                row++;
                col--;

                // Hit the bottom boundary
                if(row == rows) {

                    row = rows - 1;
                    col += 2;
                    up = true;
                }

                // Hit the left boundary
                else if(col < 0) {

                    col = 0;
                    up = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[] result = findDiagonalOrder(mat);

        System.out.println(
                "Diagonal Traversal:"
        );

        System.out.println(
                Arrays.toString(result)
        );
    }
}