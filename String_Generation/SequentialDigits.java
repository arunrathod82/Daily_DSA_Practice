package String_Generation;

/*
Problem: Sequential Digits
Platform: LeetCode
Approach: String Generation
Time Complexity: O(1)
Space Complexity: O(1)

There are only 36 possible sequential numbers,
so the solution runs in constant time.
*/

import java.util.*;

public class SequentialDigits {

    public static List<Integer> sequentialDigits(
            int low,
            int high) {

        String digits = "123456789";

        List<Integer> answer =
                new ArrayList<>();

        // Generate numbers of length 2 to 9
        for(int length = 2;
            length <= 9;
            length++) {

            for(int start = 0;
                start <= 9 - length;
                start++) {

                String subString =
                        digits.substring(
                                start,
                                start + length
                        );

                int number =
                        Integer.parseInt(subString);

                if(number >= low &&
                   number <= high) {

                    answer.add(number);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int low = 100;
        int high = 300;

        List<Integer> result =
                sequentialDigits(low, high);

        System.out.println(
                "Sequential Digits: "
                + result
        );
    }
}