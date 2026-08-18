/*
Problem: Redundant Connection
Platform: LeetCode
Approach: Union-Find / Disjoint Set Union (DSU)
Time Complexity: O(E × α(V)) ≈ O(E)
Space Complexity: O(V)

E = number of edges
V = number of vertices
*/

import java.util.*;

public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length + 1];

        // Every node is initially its own parent
        for(int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        // Process every edge
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // Both nodes already belong to same set
            // Therefore, this edge creates a cycle
            if(rootU == rootV) {
                return new int[]{u, v};
            }

            // Union the two sets
            parent[rootU] = rootV;
        }

        return new int[0];
    }

    private static int find(int[] parent, int node) {

        if(parent[node] != node) {

            // Path Compression
            parent[node] =
                    find(parent, parent[node]);
        }

        return parent[node];
    }

    public static void main(String[] args) {

        int[][] edges = {
                {1,2},
                {1,3},
                {2,3}
        };

        int[] result =
                findRedundantConnection(edges);

        System.out.println(
                "Redundant Edge: " +
                Arrays.toString(result)
        );
    }
}

