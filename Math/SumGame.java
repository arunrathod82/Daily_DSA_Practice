/*
Problem: Sum Game
Platform: LeetCode
Approach: Math / Game Theory
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class SumGame {

    public static boolean sumGame(String num) {

        int n = num.length();

        double difference = 0.0;

        // First half
        for(int i = 0; i < n / 2; i++) {
            difference += getExpectation(num.charAt(i));
        }

        // Second half
        for(int i = n / 2; i < n; i++) {
            difference -= getExpectation(num.charAt(i));
        }

        return difference != 0.0;
    }

    private static double getExpectation(char c) {

        if(c == '?') {
            return 4.5;
        }

        return c - '0';
    }

    public static void main(String[] args) {

        String num = "5023";

        boolean result = sumGame(num);

        System.out.println(
                "Alice Wins: " + result
        );
    }
}