/*
Problem: As Far from Land as Possible
Platform: LeetCode
Approach: Multi-Source BFS
Time Complexity: O(n²)
Space Complexity: O(n²)

n = number of rows (square matrix)
*/

import java.util.*;

public class AsFarFromLandAsPossible {

    public static int maxDistance(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all land cells to the queue
        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == 1) {

                    queue.offer(new int[]{row, col});
                }
            }
        }

        // All water or all land
        if(queue.isEmpty() ||
           queue.size() == rows * cols) {

            return -1;
        }

        int[][] directions = {
                {-1,0}, // Up
                {1,0},  // Down
                {0,-1}, // Left
                {0,1}   // Right
        };

        int distance = -1;

        // Multi-Source BFS
        while(!queue.isEmpty()) {

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
                       grid[newRow][newCol] == 0) {

                        // Mark visited
                        grid[newRow][newCol] = 1;

                        queue.offer(new int[]{
                                newRow,
                                newCol
                        });
                    }
                }
            }

            distance++;
        }

        return distance;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };

        int result = maxDistance(grid);

        System.out.println(
                "Maximum Distance: " + result
        );
    }
}