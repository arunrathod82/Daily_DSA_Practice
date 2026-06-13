/*
Problem: Map Word Weights
Approach: Character Weight Mapping
Time Complexity: O(total characters)
Space Complexity: O(1)
*/

import java.util.*;

public class MapWordWeights {

    public static String mapWordWeights(
            String[] words,
            int[] weights) {

        StringBuilder ans =
                new StringBuilder();

        for(String word : words) {

            int sum = 0;

            // Calculate word weight
            for(char c : word.toCharArray()) {

                int index = c - 'a';

                sum += weights[index];
            }

            int rem = sum % 26;

            char mappedChar =
                    (char) ('z' - rem);

            ans.append(mappedChar);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String[] words = {
                "abc",
                "cat",
                "dog"
        };

        int[] weights = {
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,
                25,26
        };

        String result =
                mapWordWeights(
                        words,
                        weights
                );

        System.out.println(
                "Mapped String: "
                + result
        );
    }
}