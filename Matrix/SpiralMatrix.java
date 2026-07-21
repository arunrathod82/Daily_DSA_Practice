/*
Problem: Spiral Matrix
Platform: LeetCode
Approach: Boundary Traversal (Spiral Traversal)
Time Complexity: O(m × n)
Space Complexity: O(1) (excluding the output list)

m = number of rows
n = number of columns
*/

import java.util.*;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> answer = new ArrayList<>();

        int top = 0;
        int bottom = rows - 1;

        int left = 0;
        int right = cols - 1;

        while(top <= bottom && left <= right) {

            // Traverse Left → Right
            for(int col = left;
                col <= right;
                col++) {

                answer.add(matrix[top][col]);
            }

            top++;

            // Traverse Top → Bottom
            for(int row = top;
                row <= bottom;
                row++) {

                answer.add(matrix[row][right]);
            }

            right--;

            // Traverse Right → Left
            if(top <= bottom) {

                for(int col = right;
                    col >= left;
                    col--) {

                    answer.add(matrix[bottom][col]);
                }

                bottom--;
            }

            // Traverse Bottom → Top
            if(left <= right) {

                for(int row = bottom;
                    row >= top;
                    row--) {

                    answer.add(matrix[row][left]);
                }

                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        List<Integer> result = spiralOrder(matrix);

        System.out.println("Spiral Order:");
        System.out.println(result);
    }
}