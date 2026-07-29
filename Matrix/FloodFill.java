/*
Problem: Flood Fill
Platform: LeetCode
Approach: Breadth-First Search (BFS)
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns
*/

import java.util.*;

public class FloodFill {

    public static int[][] floodFill(
            int[][] image,
            int sr,
            int sc,
            int color) {

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int original = image[sr][sc];

        // If the new color is same as original,
        // no changes are required.
        if(original == color) {
            return image;
        }

        queue.offer(new int[]{sr, sc});

        // Change the starting pixel
        image[sr][sc] = color;

        int[][] directions = {
                {-1, 0}, // Up
                {1, 0},  // Down
                {0, -1}, // Left
                {0, 1}   // Right
        };

        // BFS Traversal
        while(!queue.isEmpty()) {

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
                   image[newRow][newCol] == original) {

                    image[newRow][newCol] = color;

                    queue.offer(new int[]{
                            newRow,
                            newCol
                    });
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Flood Filled Image:");

        for(int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}