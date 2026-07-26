/*
Problem: Rotting Oranges
Platform: LeetCode
Approach: Multi-Source BFS (Breadth-First Search)
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns
*/

import java.util.*;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;

        // Add all rotten oranges to the queue
        // and count fresh oranges
        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 2) {

                    queue.offer(new int[]{i, j});
                }

                else if(grid[i][j] == 1) {

                    fresh++;
                }
            }
        }

        int[][] directions = {
                {-1, 0},   // Up
                {1, 0},    // Down
                {0, -1},   // Left
                {0, 1}     // Right
        };

        int minutes = 0;

        // BFS Level Order Traversal
        while(!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for(int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 &&
                       newRow < rows &&
                       newCol >= 0 &&
                       newCol < cols &&
                       grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        fresh--;

                        queue.offer(
                                new int[]{
                                        newRow,
                                        newCol
                                }
                        );
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int result = orangesRotting(grid);

        System.out.println(
                "Minutes Required: " + result
        );
    }
}