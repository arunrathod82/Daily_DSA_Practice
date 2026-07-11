/*
Problem: Find Common Characters
Platform: LeetCode
Approach: Frequency Count
Time Complexity: O(n × m)

n = number of words
m = average word length

Space Complexity: O(1)
*/

import java.util.*;

public class FindCommonCharacters {

    public static List<String> commonChars(
            String[] words) {

        // Frequency of first word
        int[] common = new int[26];

        for(char c : words[0].toCharArray()) {

            common[c - 'a']++;
        }

        // Compare with remaining words
        for(int i = 1;
            i < words.length;
            i++) {

            int[] freq = new int[26];

            for(char c : words[i].toCharArray()) {

                freq[c - 'a']++;
            }

            // Keep minimum frequency
            for(int j = 0;
                j < 26;
                j++) {

                common[j] =
                        Math.min(
                                common[j],
                                freq[j]
                        );
            }
        }

        List<String> answer =
                new ArrayList<>();

        // Add common characters
        for(int i = 0;
            i < 26;
            i++) {

            while(common[i] > 0) {

                answer.add(
                        String.valueOf(
                                (char)(i + 'a')
                        )
                );

                common[i]--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] words = {
                "bella",
                "label",
                "roller"
        };

        List<String> result =
                commonChars(words);

        System.out.println(
                "Common Characters: "
                + result
        );
    }
}