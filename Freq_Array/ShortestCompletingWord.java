/*
Problem: Shortest Completing Word
Platform: LeetCode
Approach: Frequency Count
Time Complexity: O(n × m)

n = number of words
m = average word length

Space Complexity: O(1)
*/

import java.util.*;

public class ShortestCompletingWord {

    public static String shortestCompletingWord(
            String licensePlate,
            String[] words) {

        int[] need = new int[26];

        // Count required letters
        for(char c : licensePlate.toCharArray()) {

            if(Character.isLetter(c)) {

                c = Character.toLowerCase(c);

                need[c - 'a']++;
            }
        }

        String answer = "";

        // Check every word
        for(String word : words) {

            int[] freq = new int[26];

            // Count letters in current word
            for(char c : word.toCharArray()) {

                freq[c - 'a']++;
            }

            boolean valid = true;

            // Verify required frequencies
            for(int i = 0; i < 26; i++) {

                if(freq[i] < need[i]) {

                    valid = false;
                    break;
                }
            }

            // Update shortest completing word
            if(valid) {

                if(answer.equals("") ||
                   word.length() < answer.length()) {

                    answer = word;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String licensePlate = "1s3 PSt";

        String[] words = {
                "step",
                "steps",
                "stripe",
                "stepple"
        };

        String result =
                shortestCompletingWord(
                        licensePlate,
                        words
                );

        System.out.println(
                "Shortest Completing Word: "
                + result
        );
    }
}