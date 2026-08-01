/*
Problem: Number of Enclaves
Platform: LeetCode
Approach: Boundary DFS (Flood Fill)
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns

(The recursion stack can take up to O(m × n) space in the worst case.)
*/

import java.util.*;

public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Remove land connected to the top and bottom boundaries
        for(int col = 0; col < cols; col++) {

            if(grid[0][col] == 1) {
                dfs(grid, 0, col);
            }

            if(grid[rows - 1][col] == 1) {
                dfs(grid, rows - 1, col);
            }
        }

        // Step 2: Remove land connected to the left and right boundaries
        for(int row = 0; row < rows; row++) {

            if(grid[row][0] == 1) {
                dfs(grid, row, 0);
            }

            if(grid[row][cols - 1] == 1) {
                dfs(grid, row, cols - 1);
            }
        }

        // Step 3: Count remaining land cells
        int count = 0;

        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(
            int[][] grid,
            int row,
            int col) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check or water
        if(row < 0 ||
           row >= rows ||
           col < 0 ||
           col >= cols ||
           grid[row][col] == 0) {

            return;
        }

        // Remove boundary-connected land
        grid[row][col] = 0;

        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        int result = numEnclaves(grid);

        System.out.println(
                "Number of Enclaves: " + result
        );
    }
}