/*
Problem: Image Smoother
Platform: LeetCode
Approach: Matrix Traversal
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns
*/

import java.util.*;

public class ImageSmoother {

    public static int[][] imageSmoother(
            int[][] img) {

        int rows = img.length;
        int cols = img[0].length;

        // 8 neighbors + current cell
        int[][] directions = {
                {-1,-1}, {-1,0}, {-1,1},
                { 0,-1}, { 0,0}, { 0,1},
                { 1,-1}, { 1,0}, { 1,1}
        };

        int[][] answer =
                new int[rows][cols];

        for(int row = 0;
            row < rows;
            row++) {

            for(int col = 0;
                col < cols;
                col++) {

                int sum = 0;
                int count = 0;

                // Visit all neighboring cells
                for(int[] dir : directions) {

                    int newRow =
                            row + dir[0];

                    int newCol =
                            col + dir[1];

                    if(newRow >= 0 &&
                       newRow < rows &&
                       newCol >= 0 &&
                       newCol < cols) {

                        sum +=
                                img[newRow][newCol];

                        count++;
                    }
                }

                // Average value
                answer[row][col] =
                        sum / count;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] img = {
                {100,200,100},
                {200,50,200},
                {100,200,100}
        };

        int[][] result =
                imageSmoother(img);

        System.out.println(
                "Smoothed Image:"
        );

        for(int[] row : result) {

            System.out.println(
                    Arrays.toString(row)
            );
        }
    }
}