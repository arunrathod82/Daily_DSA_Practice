/*
Problem: Maximum Number of Balloons
Platform: LeetCode
Approach: Frequency Counting
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaximumNumberOfBalloons {

    public static int maxNumberOfBalloons(
            String text) {

        int[] freq = new int[26];

        // Count character frequencies
        for(char c : text.toCharArray()) {

            freq[c - 'a']++;
        }

        int ans = Math.min(

                Math.min(
                        freq['b' - 'a'],
                        freq['a' - 'a']
                ),

                Math.min(
                        freq['l' - 'a'] / 2,
                        freq['o' - 'a'] / 2
                )
        );

        return Math.min(
                ans,
                freq['n' - 'a']
        );
    }

    public static void main(String[] args) {

        String text = "loonbalxballpoon";

        int result =
                maxNumberOfBalloons(text);

        System.out.println(
                "Maximum Number of Balloons: "
                + result
        );
    }
}