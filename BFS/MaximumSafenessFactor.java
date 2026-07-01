package BFS;

/*
Problem: Find the Safest Path in a Grid
Platform: LeetCode 2812
Approach:
1. Multi-Source BFS
2. Maximum Minimum Path (Dijkstra Style)

Time Complexity: O(n² log n)
Space Complexity: O(n²)
*/

import java.util.*;

public class MaximumSafenessFactor {

    private static final int[][] DIRECTIONS = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static int maximumSafenessFactor(
            List<List<Integer>> grid) {

        int n = grid.size();

        // If start or end contains thief
        if(grid.get(0).get(0) == 1 ||
           grid.get(n - 1).get(n - 1) == 1) {

            return 0;
        }

        /*
        Step 1:
        Multi-source BFS
        Calculate distance from nearest thief
        */

        int[][] distToThief =
                new int[n][n];

        for(int[] row : distToThief) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue =
                new LinkedList<>();

        // Add all thieves
        for(int r = 0; r < n; r++) {

            for(int c = 0; c < n; c++) {

                if(grid.get(r).get(c) == 1) {

                    queue.offer(
                            new int[]{r,c}
                    );

                    distToThief[r][c] = 0;
                }
            }
        }

        // BFS
        while(!queue.isEmpty()) {

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            for(int[] dir : DIRECTIONS) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 &&
                   nr < n &&
                   nc >= 0 &&
                   nc < n &&
                   distToThief[nr][nc] == -1) {

                    distToThief[nr][nc] =
                            distToThief[r][c] + 1;

                    queue.offer(
                            new int[]{nr,nc}
                    );
                }
            }
        }

        /*
        Step 2:
        Dijkstra-like Max Heap
        Maximize minimum safeness
        */

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                        (a,b) ->
                                Integer.compare(
                                        b[0],
                                        a[0]
                                )
                );

        boolean[][] visited =
                new boolean[n][n];

        maxHeap.offer(
                new int[]{
                        distToThief[0][0],
                        0,
                        0
                }
        );

        visited[0][0] = true;

        while(!maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();

            int currentSafeness = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Reached destination
            if(r == n - 1 &&
               c == n - 1) {

                return currentSafeness;
            }

            for(int[] dir : DIRECTIONS) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 &&
                   nr < n &&
                   nc >= 0 &&
                   nc < n &&
                   !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    int nextSafeness =
                            Math.min(
                                    currentSafeness,
                                    distToThief[nr][nc]
                            );

                    maxHeap.offer(
                            new int[]{
                                    nextSafeness,
                                    nr,
                                    nc
                            }
                    );
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        List<List<Integer>> grid =
                Arrays.asList(
                        Arrays.asList(0,0,1),
                        Arrays.asList(0,0,0),
                        Arrays.asList(0,0,0)
                );

        int result =
                maximumSafenessFactor(grid);

        System.out.println(
                "Maximum Safeness Factor: "
                + result
        );
    }
}
