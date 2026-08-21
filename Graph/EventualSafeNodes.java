/*
Problem: Find Eventual Safe States
Platform: LeetCode
Approach: DFS + Cycle Detection
Time Complexity: O(V + E)
Space Complexity: O(V)

V = number of nodes
E = number of edges
*/

import java.util.*;

public class EventualSafeNodes {

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        /*
         * state:
         * 0 = unvisited
         * 1 = currently visiting
         * 2 = safe
         * 3 = unsafe
         */
        int[] state = new int[n];

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            if(DFS(graph, state, i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static boolean DFS(
            int[][] graph,
            int[] state,
            int node) {

        // Node is currently in the DFS path
        // Therefore, a cycle exists
        if(state[node] == 1) {
            state[node] = 3;
            return false;
        }

        // Already known to be safe
        if(state[node] == 2) {
            return true;
        }

        // Already known to be unsafe
        if(state[node] == 3) {
            return false;
        }

        // Mark as currently visiting
        state[node] = 1;

        // Check all neighbors
        for(int neighbor : graph[node]) {

            if(!DFS(graph, state, neighbor)) {

                // This node eventually reaches a cycle
                state[node] = 3;

                return false;
            }
        }

        // No cycle reachable from this node
        state[node] = 2;

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> result =
                eventualSafeNodes(graph);

        System.out.println(
                "Eventual Safe Nodes: " + result
        );
    }
}