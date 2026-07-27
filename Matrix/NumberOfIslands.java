/*
Problem: Number of Islands
Platform: LeetCode
Approach: Depth-First Search (DFS)
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns

(The recursion stack can take up to O(m × n) space in the worst case.)
*/

import java.util.*;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int islands = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == '1') {

                    islands++;

                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    private static void dfs(
            char[][] grid,
            int row,
            int col) {

        // Boundary Check
        if(row < 0 ||
           col < 0 ||
           row >= grid.length ||
           col >= grid[0].length) {

            return;
        }

        // Water or already visited
        if(grid[row][col] == '0') {

            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Visit all four directions
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int result = numIslands(grid);

        System.out.println(
                "Number of Islands: " + result
        );
    }
}