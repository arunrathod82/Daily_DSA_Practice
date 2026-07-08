/*
Problem: Sum and Multiply Queries
Approach:
1. Prefix Sum
2. Prefix Number
3. Preprocessing
4. Math

Time Complexity:
Preprocessing : O(n)
Each Query    : O(1)
Overall       : O(n + q)

Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.List;

public class SumAndMultiplyQueries {

    public static int[] sumAndMultiply(
            String s,
            int[][] queries) {

        int m = s.length();

        final long MOD = 1_000_000_007L;

        // Store all non-zero digits
        List<Integer> digits = new ArrayList<>();

        // Maps original index -> non-zero digit index
        int[] originalToDigitsIdx =
                new int[m];

        for(int i = 0; i < m; i++) {

            char ch = s.charAt(i);

            if(ch != '0') {

                digits.add(ch - '0');

                originalToDigitsIdx[i] =
                        digits.size() - 1;
            }

            else {

                originalToDigitsIdx[i] = -1;
            }
        }

        int n = digits.size();

        if(n == 0) {

            return new int[queries.length];
        }

        /*
        nextNonZero[i]
        =
        nearest non-zero digit
        on right
        */

        int[] nextNonZero =
                new int[m];

        int lastSeen = -1;

        for(int i = m - 1;
            i >= 0;
            i--) {

            if(s.charAt(i) != '0') {

                lastSeen =
                        originalToDigitsIdx[i];
            }

            nextNonZero[i] = lastSeen;
        }

        /*
        prevNonZero[i]
        =
        nearest non-zero digit
        on left
        */

        int[] prevNonZero =
                new int[m];

        lastSeen = -1;

        for(int i = 0;
            i < m;
            i++) {

            if(s.charAt(i) != '0') {

                lastSeen =
                        originalToDigitsIdx[i];
            }

            prevNonZero[i] = lastSeen;
        }

        /*
        Prefix Sum
        */

        long[] prefSum =
                new long[n + 1];

        /*
        Prefix Number
        */

        long[] prefNum =
                new long[n + 1];

        /*
        Powers of 10
        */

        long[] pow10 =
                new long[n + 1];

        pow10[0] = 1;

        for(int i = 0;
            i < n;
            i++) {

            int digit = digits.get(i);

            prefSum[i + 1] =
                    prefSum[i] + digit;

            prefNum[i + 1] =
                    (prefNum[i] * 10 + digit)
                    % MOD;

            pow10[i + 1] =
                    (pow10[i] * 10)
                    % MOD;
        }

        int[] answer =
                new int[queries.length];

        for(int i = 0;
            i < queries.length;
            i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            int start =
                    nextNonZero[left];

            int end =
                    prevNonZero[right];

            if(start == -1 ||
               end == -1 ||
               start > end) {

                answer[i] = 0;
                continue;
            }

            /*
            Sum of digits
            */

            long sum =
                    prefSum[end + 1]
                    -
                    prefSum[start];

            /*
            Number length
            */

            int len =
                    end - start + 1;

            /*
            Extract number
            */

            long number =
                    (
                        prefNum[end + 1]
                        -
                        (
                            prefNum[start]
                            * pow10[len]
                        ) % MOD
                        +
                        MOD
                    ) % MOD;

            answer[i] =
                    (int)
                    (
                        (number * (sum % MOD))
                        % MOD
                    );
        }

        return answer;
    }

    public static void main(String[] args) {

        String s = "1023045";

        int[][] queries = {
                {0, 6},
                {1, 4},
                {2, 6}
        };

        int[] result =
                sumAndMultiply(s, queries);

        System.out.print("Answers: ");

        for(int value : result) {

            System.out.print(
                    value + " "
            );
        }
    }
}