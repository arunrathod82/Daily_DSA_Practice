/*
Problem: Cheapest Flights Within K Stops
Platform: LeetCode
Approach: BFS + Relaxation
Time Complexity: O(K × E)
Space Complexity: O(V + E)

V = number of cities
E = number of flights
*/

import java.util.*;

public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        // Create adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for(int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(
                    new int[]{to, price}
            );
        }

        /*
         * distance[i] = cheapest price found
         * to reach city i using the allowed
         * number of stops processed so far.
         */
        int[] distance = new int[n];

        Arrays.fill(
                distance,
                Integer.MAX_VALUE
        );

        distance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(src);

        int stops = 0;

        while(!queue.isEmpty() && stops <= k) {

            int size = queue.size();

            /*
             * Copy distance so that flights taken
             * in this level do not affect another
             * city in the same level.
             */
            int[] temp = distance.clone();

            for(int i = 0; i < size; i++) {

                int city = queue.poll();

                for(int[] flight : graph.get(city)) {

                    int nextCity = flight[0];
                    int price = flight[1];

                    if(distance[city] != Integer.MAX_VALUE) {

                        int newCost =
                                distance[city] + price;

                        if(newCost < temp[nextCity]) {

                            temp[nextCity] = newCost;

                            queue.offer(nextCity);
                        }
                    }
                }
            }

            distance = temp;

            stops++;
        }

        if(distance[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return distance[dst];
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,3,100},
                {0,2,500}
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        int result =
                findCheapestPrice(
                        n,
                        flights,
                        src,
                        dst,
                        k
                );

        System.out.println(
                "Cheapest Price: " + result
        );
    }
}