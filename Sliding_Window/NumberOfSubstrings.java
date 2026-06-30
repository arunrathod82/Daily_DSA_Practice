/*
Problem: Number of Substrings Containing All Three Characters
Platform: LeetCode 1358
Approach: Sliding Window
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class NumberOfSubstrings {

    public static int numberOfSubstrings(
            String s) {

        int[] freq = new int[3];

        int left = 0;

        int ans = 0;

        for(int right = 0;
            right < s.length();
            right++) {

            // Add current character
            freq[s.charAt(right) - 'a']++;

            // Valid window
            while(freq[0] > 0 &&
                  freq[1] > 0 &&
                  freq[2] > 0) {

                /*
                All substrings starting from
                left and ending from right
                to end are valid
                */

                ans += s.length() - right;

                // Shrink window
                freq[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "abcabc";

        int result =
                numberOfSubstrings(s);

        System.out.println(
                "Number of Valid Substrings: "
                + result
        );
    }
}