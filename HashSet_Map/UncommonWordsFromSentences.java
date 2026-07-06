/*
Problem: Uncommon Words from Two Sentences
Platform: LeetCode
Approach: HashMap Frequency Count
Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/

import java.util.*;

public class UncommonWordsFromSentences {

    public static String[] uncommonFromSentences(
            String s1,
            String s2) {

        HashMap<String, Integer> freq =
                new HashMap<>();

        // Split first sentence
        String[] words1 = s1.split(" ");

        for(String word : words1) {

            freq.put(
                    word,
                    freq.getOrDefault(word, 0) + 1
            );
        }

        // Split second sentence
        String[] words2 = s2.split(" ");

        for(String word : words2) {

            freq.put(
                    word,
                    freq.getOrDefault(word, 0) + 1
            );
        }

        List<String> ans =
                new ArrayList<>();

        // Collect words appearing exactly once
        for(String word : freq.keySet()) {

            if(freq.get(word) == 1) {

                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String s1 = "this apple is sweet";

        String s2 = "this apple is sour";

        String[] result =
                uncommonFromSentences(s1, s2);

        System.out.println(
                "Uncommon Words: "
                + Arrays.toString(result)
        );
    }
}