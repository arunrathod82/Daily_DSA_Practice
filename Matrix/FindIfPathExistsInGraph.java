/*
Problem: Find if Path Exists in Graph
Platform: LeetCode
Approach: Breadth-First Search (BFS)
Time Complexity: O(V + E)
Space Complexity: O(V + E)

V = Number of Vertices
E = Number of Edges
*/

import java.util.*;

public class FindIfPathExistsInGraph {

    public static boolean validPath(
            int n,
            int[][] edges,
            int source,
            int destination) {

        // Create Adjacency List
        List<List<Integer>> graph =
                new ArrayList<>();

        for(int i = 0; i < n; i++) {

            graph.add(new ArrayList<>());
        }

        // Build Undirected Graph
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue =
                new LinkedList<>();

        boolean[] visited =
                new boolean[n];

        queue.offer(source);
        visited[source] = true;

        // BFS Traversal
        while(!queue.isEmpty()) {

            int node = queue.poll();

            if(node == destination) {

                return true;
            }

            for(int neighbor : graph.get(node)) {

                if(!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] edges = {
                {0,1},
                {1,2},
                {2,0}
        };

        int source = 0;
        int destination = 2;

        boolean result =
                validPath(
                        n,
                        edges,
                        source,
                        destination
                );

        System.out.println(
                "Path Exists: " + result
        );
    }
}