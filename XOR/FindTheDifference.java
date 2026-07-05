package XOR;

/*
Problem: Find the Difference
Platform: LeetCode
Approach: XOR
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class FindTheDifference {

    public static char findTheDifference(
            String s,
            String t) {

        char ans = 0;

        // XOR all characters from s
        for(char c : s.toCharArray()) {

            ans ^= c;
        }

        // XOR all characters from t
        for(char c : t.toCharArray()) {

            ans ^= c;
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        char result =
                findTheDifference(s, t);

        System.out.println(
                "Extra Character: "
                + result
        );
    }
}
