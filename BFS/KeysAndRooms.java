/*
Problem: Keys and Rooms
Platform: LeetCode
Approach: Breadth-First Search (BFS)
Time Complexity: O(V + E)
Space Complexity: O(V)

V = number of rooms
E = total number of keys
*/

import java.util.*;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(
            List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        // We can enter Room 0 initially
        queue.offer(0);
        visited[0] = true;

        // BFS
        while(!queue.isEmpty()) {

            int room = queue.poll();

            // Get all keys present in this room
            for(int key : rooms.get(room)) {

                if(!visited[key]) {

                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        // Check whether every room was visited
        for(int i = 0; i < n; i++) {

            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        System.out.println(
                "Can visit all rooms: "
                + canVisitAllRooms(rooms)
        );
    }
}