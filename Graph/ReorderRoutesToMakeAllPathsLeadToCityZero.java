/*
Problem: Reorder Routes to Make All Paths Lead to the City Zero
Platform: LeetCode
Approach: DFS + Graph
Time Complexity: O(n)
Space Complexity: O(n)

1 = original direction → needs reversal
0 = reverse direction → already points toward 0
*/

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToCityZero {

    static int ans = 0;

    public static int minReorder(
            int n,
            int[][] connections) {

        List<List<int[]>> graph = new ArrayList<>();

        // Create graph
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        /*
         * For original edge:
         *
         * a → b
         *
         * Store:
         * a → b with cost 1
         * b → a with cost 0
         */
        for(int[] connection : connections) {

            int a = connection[0];
            int b = connection[1];

            graph.get(a).add(
                    new int[]{b, 1}
            );

            graph.get(b).add(
                    new int[]{a, 0}
            );
        }

        boolean[] visited = new boolean[n];

        DFS(0, graph, visited);

        return ans;
    }

    private static void DFS(
            int city,
            List<List<int[]>> graph,
            boolean[] visited) {

        visited[city] = true;

        for(int[] edge : graph.get(city)) {

            int neighbour = edge[0];
            int cost = edge[1];

            if(!visited[neighbour]) {

                /*
                 * cost = 1:
                 * Original road points away from city 0.
                 * Therefore, reverse it.
                 *
                 * cost = 0:
                 * Road already points toward city 0.
                 */
                ans += cost;

                DFS(
                        neighbour,
                        graph,
                        visited
                );
            }
        }
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] connections = {
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        };

        ans = 0;

        int result =
                minReorder(
                        n,
                        connections
                );

        System.out.println(
                "Minimum Reorders: " + result
        );
    }
}