/*
Problem: Longest Substring Without Repeating Characters
Platform: LeetCode
Approach: Sliding Window + HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {

            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Longest Substring Length: " + result);
    }
}