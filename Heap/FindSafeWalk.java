/*
Problem: Find a Safe Walk Through a Grid
Approach:
1. Priority Queue (Max Heap)
2. Dijkstra-like Greedy Traversal

Time Complexity: O(n * m * log(n*m))
Space Complexity: O(n * m)
*/

import java.util.*;

public class FindSafeWalk {

    private static final int[][] DIR = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static boolean findSafeWalk(
            List<List<Integer>> grid,
            int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        /*
        Max Heap:
        Store state with maximum remaining health first
        */

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                        (a,b) -> b[0] - a[0]
                );

        /*
        best[r][c] =
        maximum health remaining
        when reaching cell
        */

        int[][] best = new int[n][m];

        for(int[] row : best) {
            Arrays.fill(row, -1);
        }

        // Initial health after entering start cell
        int startHealth =
                health - grid.get(0).get(0);

        if(startHealth <= 0) {
            return false;
        }

        best[0][0] = startHealth;

        maxHeap.offer(
                new int[]{
                        startHealth,
                        0,
                        0
                }
        );

        while(!maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();

            int currHealth = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Reached destination
            if(r == n - 1 &&
               c == m - 1) {

                return true;
            }

            for(int[] dir : DIR) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 &&
                   nr < n &&
                   nc >= 0 &&
                   nc < m) {

                    int newHealth =
                            currHealth
                            -
                            grid.get(nr).get(nc);

                    /*
                    Visit only if:
                    1. Health remains positive
                    2. Better than previous path
                    */

                    if(newHealth > 0 &&
                       newHealth > best[nr][nc]) {

                        best[nr][nc] = newHealth;

                        maxHeap.offer(
                                new int[]{
                                        newHealth,
                                        nr,
                                        nc
                                }
                        );
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        List<List<Integer>> grid =
                Arrays.asList(
                        Arrays.asList(0,1,1),
                        Arrays.asList(1,1,0),
                        Arrays.asList(1,0,0)
                );

        int health = 5;

        boolean result =
                findSafeWalk(grid, health);

        System.out.println(
                "Safe Path Exists: "
                + result
        );
    }
}