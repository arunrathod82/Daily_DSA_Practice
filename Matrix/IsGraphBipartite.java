/*
Problem: Is Graph Bipartite?
Platform: LeetCode
Approach: BFS + 2-Coloring
Time Complexity: O(V + E)
Space Complexity: O(V)

V = number of vertices
E = number of edges
*/

import java.util.*;

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // -1 = uncolored
        //  0 = color 0
        //  1 = color 1
        int[] color = new int[n];

        Arrays.fill(color, -1);

        Queue<Integer> queue = new LinkedList<>();

        // Graph may have multiple disconnected components
        for(int i = 0; i < n; i++) {

            if(color[i] == -1) {

                // Start a new component
                color[i] = 0;
                queue.offer(i);

                while(!queue.isEmpty()) {

                    int node = queue.poll();

                    for(int neighbor : graph[node]) {

                        // If neighbor is not colored
                        if(color[neighbor] == -1) {

                            // Give opposite color
                            color[neighbor] =
                                    1 - color[node];

                            queue.offer(neighbor);
                        }

                        // Adjacent nodes have same color
                        else if(color[neighbor] == color[node]) {

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };

        boolean result = isBipartite(graph);

        System.out.println(
                "Is Bipartite: " + result
        );
    }
}