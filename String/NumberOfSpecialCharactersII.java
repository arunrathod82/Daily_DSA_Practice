/*
Problem: Count the Number of Special Characters II
Platform: LeetCode
Approach: Store last lowercase index and first uppercase index
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class NumberOfSpecialCharactersII {

    public static int numberOfSpecialChars(String word) {

        int[] lower = new int[26];
        int[] upper = new int[26];

        Arrays.fill(lower, -1);
        Arrays.fill(upper, Integer.MAX_VALUE);

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if(Character.isLowerCase(c)) {
                lower[c - 'a'] = i;
            }

            else {

                // store first uppercase occurrence only
                if(upper[c - 'A'] == Integer.MAX_VALUE) {
                    upper[c - 'A'] = i;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {

            if(lower[i] != -1 &&
               upper[i] != Integer.MAX_VALUE &&
               lower[i] < upper[i]) {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String word = "aaAbBcC";

        int result = numberOfSpecialChars(word);

        System.out.println("Number of Special Characters: " + result);
    }
}