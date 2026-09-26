import java.util.*;

// Problem: Pascal's Triangle
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        // Build the triangle row by row
        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                // First and last elements of every row are 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {

                    // Add the two elements directly above
                    int value = triangle.get(i - 1).get(j - 1)
                              + triangle.get(i - 1).get(j);

                    row.add(value);
                }
            }

            // Add the completed row to the triangle
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {

        PascalsTriangle obj = new PascalsTriangle();

        int numRows = 5;

        List<List<Integer>> result = obj.generate(numRows);

        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}