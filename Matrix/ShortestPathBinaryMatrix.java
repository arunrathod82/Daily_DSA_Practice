/*
Problem: Shortest Path in Binary Matrix
Platform: LeetCode
Approach: Breadth-First Search (BFS)
Time Complexity: O(n²)
Space Complexity: O(n²)

n = number of rows (square matrix)
*/

import java.util.*;

public class ShortestPathBinaryMatrix {

    public static int shortestPathBinaryMatrix(
            int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Start or destination is blocked
        if(grid[0][0] == 1 ||
           grid[rows - 1][cols - 1] == 1) {

            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});

        // Mark starting cell as visited
        grid[0][0] = 1;

        // 8 Possible Directions
        int[][] directions = {
                {-1,-1}, {-1,0}, {-1,1},
                {0,-1},           {0,1},
                {1,-1},  {1,0},   {1,1}
        };

        int length = 1;

        // BFS
        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Destination reached
                if(row == rows - 1 &&
                   col == cols - 1) {

                    return length;
                }

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

            length++;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,1},
                {1,0}
        };

        int result =
                shortestPathBinaryMatrix(grid);

        System.out.println(
                "Shortest Path Length: "
                + result
        );
    }
}