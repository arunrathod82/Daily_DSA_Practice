/*
Problem: Unique Number of Occurrences
Platform: LeetCode
Approach: HashMap + HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class UniqueNumberOfOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int key : freq.keySet()) {

            int count = freq.get(key);

            if(set.contains(count)) {
                return false;
            }

            set.add(count);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 1, 3};

        boolean result = uniqueOccurrences(arr);

        System.out.println("Unique Occurrences: " + result);
    }
}