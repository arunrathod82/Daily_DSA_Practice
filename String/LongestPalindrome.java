/*
Problem: Longest Palindrome
Platform: LeetCode
Approach: HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int length = 0;

        for(int i = 0; i < s.length(); i++) {

            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }

            else {
                set.remove(s.charAt(i));
                length += 2;
            }
        }

        if(!set.isEmpty()) {
            length++;
        }

        return length;
    }

    public static void main(String[] args) {

        String s = "abccccdd";

        int result = longestPalindrome(s);

        System.out.println("Longest Palindrome Length: " + result);
    }
}