/*
Problem: Network Delay Time
Platform: LeetCode
Approach: Dijkstra's Algorithm
Time Complexity: O((V + E) log V)
Space Complexity: O(V + E)

V = number of nodes
E = number of edges
*/

import java.util.*;

public class NetworkDelayTime {

    public static int networkDelayTime(
            int[][] times,
            int n,
            int k) {

        // Adjacency List
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for(int[] time : times) {

            int u = time[0];
            int v = time[1];
            int weight = time[2];

            graph.get(u).add(
                    new int[]{v, weight}
            );
        }

        // Shortest distance from k
        int[] distance = new int[n + 1];

        Arrays.fill(
                distance,
                Integer.MAX_VALUE
        );

        distance[k] = 0;

        // Min-Heap
        // [node, distance]
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a[1], b[1])
                );

        pq.offer(new int[]{k, 0});

        // Dijkstra
        while(!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int currentDistance = current[1];

            // Ignore outdated entry
            if(currentDistance > distance[node]) {
                continue;
            }

            for(int[] edge : graph.get(node)) {

                int neighbor = edge[0];
                int weight = edge[1];

                int newDistance =
                        currentDistance + weight;

                // Relaxation
                if(newDistance < distance[neighbor]) {

                    distance[neighbor] = newDistance;

                    pq.offer(
                            new int[]{
                                    neighbor,
                                    newDistance
                            }
                    );
                }
            }
        }

        // Find maximum shortest distance
        int maxTime = 0;

        for(int i = 1; i <= n; i++) {

            if(distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxTime =
                    Math.max(maxTime, distance[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {

        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };

        int n = 4;
        int k = 2;

        int result =
                networkDelayTime(
                        times,
                        n,
                        k
                );

        System.out.println(
                "Network Delay Time: " + result
        );
    }
}