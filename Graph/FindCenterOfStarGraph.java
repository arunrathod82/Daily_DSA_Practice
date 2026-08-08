package Graph;

/*
Problem: Find Center of Star Graph
Platform: LeetCode
Approach: Compare the first two edges
Time Complexity: O(1)
Space Complexity: O(1)
*/

import java.util.*;

public class FindCenterOfStarGraph {

    public static int findCenter(int[][] edges) {

        int[] edge1 = edges[0];
        int[] edge2 = edges[1];

        // If the first node of edge1
        // appears in edge2, it is the center
        if(edge1[0] == edge2[0] ||
           edge1[0] == edge2[1]) {

            return edge1[0];
        }

        // Otherwise edge1[1] is the center
        return edge1[1];
    }

    public static void main(String[] args) {

        int[][] edges = {
                {1,2},
                {2,3},
                {2,4}
        };

        int center = findCenter(edges);

        System.out.println(
                "Center of Star Graph: " + center
        );
    }
}
