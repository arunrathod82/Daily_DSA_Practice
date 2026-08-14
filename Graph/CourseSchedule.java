/*
Problem: Course Schedule
Platform: LeetCode
Approach: Kahn's Algorithm / Topological Sort (BFS)
Time Complexity: O(V + E)
Space Complexity: O(V + E)

V = number of courses
E = number of prerequisites
*/

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(
            int numCourses,
            int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Indegree of every course
        int[] inDegree = new int[numCourses];

        // Create empty lists
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for(int[] course : prerequisites) {

            int a = course[0];
            int b = course[1];

            // b -> a
            // To take course a, we must first complete b
            graph.get(b).add(a);

            inDegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Courses with no prerequisites
        for(int i = 0; i < numCourses; i++) {

            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        // Kahn's Algorithm
        while(!queue.isEmpty()) {

            int course = queue.poll();

            count++;

            // Remove this course as a prerequisite
            for(int neighbour : graph.get(course)) {

                inDegree[neighbour]--;

                // All prerequisites completed
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // If every course was processed,
        // there is no cycle.
        return count == numCourses;
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1,0},
                {2,1},
                {3,2}
        };

        System.out.println(
                "Can Finish: " +
                canFinish(numCourses, prerequisites)
        );
    }
}