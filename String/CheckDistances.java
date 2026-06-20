/*
Problem: Check Distances Between Same Letters
Platform: LeetCode
Approach: Store first occurrence index
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class CheckDistances {

    public static boolean checkDistances(
            String s,
            int[] distance) {

        int[] first = new int[26];

        Arrays.fill(first, -1);

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            int idx = c - 'a';

            // First occurrence
            if(first[idx] == -1) {

                first[idx] = i;
            }

            // Second occurrence
            else {

                int dist =
                        i - first[idx] - 1;

                if(dist != distance[idx]) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "abaccb";

        int[] distance = {
                1, 3, 0, 5, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0
        };

        boolean result =
                checkDistances(s, distance);

        System.out.println(
                "Valid Distances: "
                + result
        );
    }
}