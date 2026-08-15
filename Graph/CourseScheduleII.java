/*
Problem: Course Schedule II
Platform: LeetCode
Approach: Kahn's Algorithm / Topological Sort using BFS
Time Complexity: O(V + E)
Space Complexity: O(V + E)

V = number of courses
E = number of prerequisites
*/

import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(
            int numCourses,
            int[][] prerequisites) {

        // Adjacency List
        List<List<Integer>> graph = new ArrayList<>();

        // Indegree of every course
        int[] inDegree = new int[numCourses];

        // Create graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and calculate indegree
        for(int[] course : prerequisites) {

            int a = course[0];
            int b = course[1];

            // b -> a
            graph.get(b).add(a);

            inDegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add courses with no prerequisites
        for(int i = 0; i < numCourses; i++) {

            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] answer = new int[numCourses];

        int index = 0;

        // Kahn's Algorithm
        while(!queue.isEmpty()) {

            int course = queue.poll();

            answer[index] = course;
            index++;

            // Remove current course as prerequisite
            for(int neighbor : graph.get(course)) {

                inDegree[neighbor]--;

                if(inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Cycle exists
        if(index != numCourses) {
            return new int[0];
        }

        return answer;
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };

        int[] result =
                findOrder(numCourses, prerequisites);

        System.out.println(
                "Course Order: " +
                Arrays.toString(result)
        );
    }
}