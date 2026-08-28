import java.util.*;

class Solution {

    // Problem: Detonate the Maximum Bombs
    // Platform: LeetCode
    // Approach: DFS + Graph
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        // Build graph
        for(int i = 0; i < n; i++){

            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for(int j = 0; j < n; j++){

                if(i == j){
                    continue;
                }

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1 - x2;
                long dy = y1 - y2;

                long distanceSquared =
                        dx * dx + dy * dy;

                long radiusSquared =
                        r1 * r1;

                // If bomb j is inside bomb i's range,
                // bomb i can detonate bomb j.
                if(distanceSquared <= radiusSquared){
                    graph.get(i).add(j);
                }
            }
        }

        int answer = 0;

        // Try detonating every bomb
        for(int i = 0; i < n; i++){

            boolean[] visited = new boolean[n];

            int count = DFS(i, graph, visited);

            answer = Math.max(answer, count);
        }

        return answer;
    }

    // DFS to find all bombs that can be detonated
    // starting from the given bomb
    public int DFS(
            int bomb,
            List<List<Integer>> graph,
            boolean[] visited){

        visited[bomb] = true;

        // Count the current bomb
        int count = 1;

        // Visit all bombs that this bomb can detonate
        for(int neighbour : graph.get(bomb)){

            if(!visited[neighbour]){

                count += DFS(
                        neighbour,
                        graph,
                        visited
                );
            }
        }

        return count;
    }

    // Main function for local testing
    public static void main(String[] args){

        Solution solution = new Solution();

        int[][] bombs = {
                {2, 1, 3},
                {6, 1, 4}
        };

        int result =
                solution.maximumDetonation(bombs);

        System.out.println("Maximum bombs detonated: " + result);
    }
}