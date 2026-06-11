/*
Problem: Assign Edge Weights
Approach: DFS + Fast Power
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class AssignEdgeWeights {

    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        List<Integer>[] graph =
                new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for(int[] e : edges) {

            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // Find maximum depth
        int maxDepth = dfs(1, 0, graph);

        // Result = 2^(maxDepth-1)
        return power(2, maxDepth - 1);
    }

    private int dfs(
            int node,
            int parent,
            List<Integer>[] graph) {

        int depth = 0;

        for(int nei : graph[node]) {

            if(nei != parent) {

                depth = Math.max(
                        depth,
                        1 + dfs(nei, node, graph)
                );
            }
        }

        return depth;
    }

    // Fast exponentiation
    private int power(long a, int b) {

        long res = 1;

        while(b > 0) {

            if((b & 1) == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;

            b >>= 1;
        }

        return (int) res;
    }

    public static void main(String[] args) {

        AssignEdgeWeights solution =
                new AssignEdgeWeights();

        int[][] edges = {
                {1,2},
                {1,3},
                {3,4},
                {3,5}
        };

        int result =
                solution.assignEdgeWeights(edges);

        System.out.println(
                "Assigned Edge Weights: "
                + result
        );
    }
}