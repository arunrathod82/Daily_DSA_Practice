/*
Problem: Island Perimeter
Platform: LeetCode
Approach: Count Shared Edges
Time Complexity: O(m × n)
Space Complexity: O(1)

m = number of rows
n = number of columns
*/

import java.util.*;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == 1) {

                    // Every land cell contributes 4 sides
                    perimeter += 4;

                    // Shared edge with right neighbor
                    if(col + 1 < cols &&
                       grid[row][col + 1] == 1) {

                        perimeter -= 2;
                    }

                    // Shared edge with bottom neighbor
                    if(row + 1 < rows &&
                       grid[row + 1][col] == 1) {

                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        int result = islandPerimeter(grid);

        System.out.println(
                "Island Perimeter: " + result
        );
    }
}