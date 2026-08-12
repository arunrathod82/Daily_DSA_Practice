/*
Problem: Minimum Number of Vertices to Reach All Nodes
Platform: LeetCode
Approach: Indegree
Time Complexity: O(V + E)
Space Complexity: O(V)

V = number of vertices
E = number of edges
*/

import java.util.*;

public class MinVerticesToReachAllNodes {

    public static List<Integer> findSmallestSetOfVertices(
            int n,
            List<List<Integer>> edges) {

        int[] inDegree = new int[n];

        // Calculate indegree of every vertex
        for(List<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);

            inDegree[v]++;
        }

        List<Integer> ans = new ArrayList<>();

        // Vertices with indegree 0
        for(int i = 0; i < n; i++) {

            if(inDegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 6;

        List<List<Integer>> edges = new ArrayList<>();

        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));

        List<Integer> result =
                findSmallestSetOfVertices(n, edges);

        System.out.println(
                "Smallest Set of Vertices: " + result
        );
    }
}