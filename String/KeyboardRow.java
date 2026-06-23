/*
Problem: Keyboard Row
Platform: LeetCode
Approach: String Matching
Time Complexity: O(n * m)

n = number of words
m = average word length
*/

import java.util.*;

public class KeyboardRow {

    public static String[] findWords(
            String[] words) {

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> ans =
                new ArrayList<>();

        for(String word : words) {

            String original = word;

            word = word.toLowerCase();

            char first = word.charAt(0);

            String row = "";

            // Decide keyboard row
            if(row1.contains("" + first)) {

                row = row1;
            }

            else if(row2.contains("" + first)) {

                row = row2;
            }

            else {

                row = row3;
            }

            boolean valid = true;

            // Check all characters
            for(char c : word.toCharArray()) {

                if(!row.contains("" + c)) {

                    valid = false;
                    break;
                }
            }

            if(valid) {
                ans.add(original);
            }
        }

        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] words = {
                "Hello",
                "Alaska",
                "Dad",
                "Peace"
        };

        String[] result =
                findWords(words);

        System.out.println(
                "Valid Words: "
                + Arrays.toString(result)
        );
    }
}