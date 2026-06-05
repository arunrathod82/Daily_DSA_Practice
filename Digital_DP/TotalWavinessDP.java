package Digital_DP;

/*
Problem: Total Waviness in Range
Approach: Digit DP + Memoization
Time Complexity: O(d * states)

d = number of digits
*/

import java.util.*;

public class TotalWavinessDP {

    public long totalWaviness(long num1, long num2) {

        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long limitNum) {

        // Numbers with < 3 digits
        // cannot have waviness
        if(limitNum < 100) {
            return 0;
        }

        String s = Long.toString(limitNum);

        int n = s.length();

        /*
        Dimensions:
        [idx]
        [prevDigit + 1]
        [prev2Digit + 1]
        [isLess]
        [isStarted]
        */

        Long[][][][][] dpMemo =
                new Long[n][11][11][2][2];

        Long[][] countMemo =
                new Long[n][2];

        return dp(
                0,
                -1,
                -1,
                0,
                0,
                s,
                n,
                dpMemo,
                countMemo
        );
    }

    private long dp(
            int idx,
            int prevDigit,
            int prev2Digit,
            int isLess,
            int isStarted,
            String s,
            int n,
            Long[][][][][] dpMemo,
            Long[][] countMemo) {

        // End of number
        if(idx == n) {
            return 0;
        }

        int p1 = prevDigit + 1;
        int p2 = prev2Digit + 1;

        if(dpMemo[idx][p1][p2][isLess][isStarted]
                != null) {

            return dpMemo[idx][p1][p2]
                         [isLess][isStarted];
        }

        int maxDigit =
                (isLess == 1)
                ? 9
                : (s.charAt(idx) - '0');

        long totalWaves = 0;

        for(int digit = 0;
            digit <= maxDigit;
            digit++) {

            int nextIsLess =
                    (isLess == 1 ||
                     digit < maxDigit)
                    ? 1
                    : 0;

            // Leading zeros
            if(isStarted == 0) {

                if(digit == 0) {

                    totalWaves += dp(
                            idx + 1,
                            -1,
                            -1,
                            nextIsLess,
                            0,
                            s,
                            n,
                            dpMemo,
                            countMemo
                    );
                }

                else {

                    totalWaves += dp(
                            idx + 1,
                            digit,
                            -1,
                            nextIsLess,
                            1,
                            s,
                            n,
                            dpMemo,
                            countMemo
                    );
                }
            }

            else {

                long currentWave = 0;

                // Check peak or valley
                if(prev2Digit != -1 &&
                   prevDigit != -1) {

                    boolean isPeak =
                            (prevDigit > prev2Digit)
                            &&
                            (prevDigit > digit);

                    boolean isValley =
                            (prevDigit < prev2Digit)
                            &&
                            (prevDigit < digit);

                    if(isPeak || isValley) {

                        currentWave =
                                countWays(
                                        idx + 1,
                                        nextIsLess,
                                        s,
                                        n,
                                        countMemo
                                );
                    }
                }

                totalWaves +=
                        currentWave
                        +
                        dp(
                                idx + 1,
                                digit,
                                prevDigit,
                                nextIsLess,
                                1,
                                s,
                                n,
                                dpMemo,
                                countMemo
                        );
            }
        }

        return dpMemo[idx][p1][p2]
                      [isLess][isStarted]
                = totalWaves;
    }

    // Count remaining valid suffixes
    private long countWays(
            int idx,
            int isLess,
            String s,
            int n,
            Long[][] countMemo) {

        if(idx == n) {
            return 1;
        }

        if(countMemo[idx][isLess] != null) {

            return countMemo[idx][isLess];
        }

        int maxDigit =
                (isLess == 1)
                ? 9
                : (s.charAt(idx) - '0');

        long ways = 0;

        for(int digit = 0;
            digit <= maxDigit;
            digit++) {

            int nextIsLess =
                    (isLess == 1 ||
                     digit < maxDigit)
                    ? 1
                    : 0;

            ways += countWays(
                    idx + 1,
                    nextIsLess,
                    s,
                    n,
                    countMemo
            );
        }

        return countMemo[idx][isLess]
                = ways;
    }

    public static void main(String[] args) {

        TotalWavinessDP solution =
                new TotalWavinessDP();

        long num1 = 100;
        long num2 = 500;

        long result =
                solution.totalWaviness(
                        num1,
                        num2
                );

        System.out.println(
                "Total Waviness: " + result
        );
    }
}
