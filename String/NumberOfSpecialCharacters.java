/*
Problem: Count the Number of Special Characters I
Platform: LeetCode
Approach: Track lowercase and uppercase occurrences
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class NumberOfSpecialCharacters {

    public static int numberOfSpecialChars(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for(char c : word.toCharArray()) {

            if(Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            }
            else {
                upper[c - 'A'] = true;
            }
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {

            if(lower[i] && upper[i]) {
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