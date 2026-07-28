/*
Problem: 01 Matrix
Platform: LeetCode
Approach: Multi-Source BFS
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns
*/

import java.util.*;

public class Matrix01 {

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] distance = new int[m][n];

        // Initialize queue with all 0s
        // Mark all 1s as unvisited (-1)
        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0) {

                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }

                else {

                    distance[i][j] = -1;
                }
            }
        }

        // Four possible directions
        int[][] directions = {
                {-1, 0}, // Up
                {1, 0},  // Down
                {0, -1}, // Left
                {0, 1}   // Right
        };

        // Multi-Source BFS
        while(!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for(int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 &&
                   newRow < m &&
                   newCol >= 0 &&
                   newCol < n &&
                   distance[newRow][newCol] == -1) {

                    distance[newRow][newCol] =
                            distance[row][col] + 1;

                    queue.offer(
                            new int[]{
                                    newRow,
                                    newCol
                            }
                    );
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        int[][] result = updateMatrix(mat);

        System.out.println("Distance Matrix:");

        for(int[] row : result) {

            System.out.println(Arrays.toString(row));
        }
    }
}