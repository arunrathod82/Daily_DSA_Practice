/*
Problem: Max Area of Island
Platform: LeetCode
Approach: Depth-First Search (DFS)
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns

(The recursion stack can take up to O(m × n) space in the worst case.)
*/

import java.util.*;

public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        // Traverse every cell
        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == 1) {

                    int area = dfs(grid, row, col);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(
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

            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        int area = 1;

        // Explore all four directions
        area += dfs(grid, row - 1, col); // Up
        area += dfs(grid, row + 1, col); // Down
        area += dfs(grid, row, col - 1); // Left
        area += dfs(grid, row, col + 1); // Right

        return area;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,1,0,0},
                {1,1,1,0,1},
                {0,1,0,0,1},
                {0,0,0,1,1}
        };

        int result = maxAreaOfIsland(grid);

        System.out.println(
                "Maximum Island Area: " + result
        );
    }
}