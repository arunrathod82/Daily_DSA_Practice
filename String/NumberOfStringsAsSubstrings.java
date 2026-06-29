/*
Problem: Check If a String Contains All Binary Codes
(LeetCode 1967 - Number of Strings That Appear as Substrings in Word)

Approach: String contains()
Time Complexity: O(n * m)
Space Complexity: O(1)
*/

import java.util.*;

public class NumberOfStringsAsSubstrings {

    public static int numOfStrings(
            String[] patterns,
            String word) {

        int count = 0;

        for(String pattern : patterns) {

            // Check substring
            if(word.contains(pattern)) {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] patterns = {
                "a",
                "abc",
                "bc",
                "d"
        };

        String word = "abc";

        int result =
                numOfStrings(patterns, word);

        System.out.println(
                "Number of Matching Strings: "
                + result
        );
    }
}