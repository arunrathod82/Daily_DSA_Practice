/*
Problem: Count the Number of Consistent Strings
Platform: LeetCode
Approach: HashSet
Time Complexity: O(n * m)

n = number of words
m = average word length

Space Complexity: O(1)
*/

import java.util.*;

public class CountConsistentStrings {

    public static int countConsistentStrings(
            String allowed,
            String[] words) {

        HashSet<Character> set =
                new HashSet<>();

        // Store allowed characters
        for(char c : allowed.toCharArray()) {

            set.add(c);
        }

        int count = 0;

        // Check every word
        for(String word : words) {

            boolean valid = true;

            for(char c : word.toCharArray()) {

                if(!set.contains(c)) {

                    valid = false;
                    break;
                }
            }

            if(valid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String allowed = "ab";

        String[] words = {
                "ad",
                "bd",
                "aaab",
                "baa",
                "badab"
        };

        int result =
                countConsistentStrings(
                        allowed,
                        words
                );

        System.out.println(
                "Consistent Strings Count: "
                + result
        );
    }
}