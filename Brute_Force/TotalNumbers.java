import java.util.*;

// Problem: Find the Number of Valid 3-Digit Even Numbers
// Platform: LeetCode
// Approach: Brute Force + HashSet
// Time Complexity: O(n^3)
// Space Complexity: O(n^3)

public class TotalNumbers {

    public int totalNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();

        // Choose the hundreds, tens, and units digits
        for (int i = 0; i < digits.length; i++) {

            for (int j = 0; j < digits.length; j++) {

                for (int k = 0; k < digits.length; k++) {

                    // The same array element cannot be reused
                    if (i == j || j == k || k == i) {
                        continue;
                    }

                    // First digit cannot be zero
                    // Last digit must be even
                    if (digits[i] != 0 && digits[k] % 2 == 0) {

                        int number = digits[i] * 100
                                   + digits[j] * 10
                                   + digits[k];

                        // HashSet removes duplicate numbers
                        set.add(number);
                    }
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        TotalNumbers obj = new TotalNumbers();

        int[] digits = {1, 2, 3, 4};

        System.out.println(
            "Number of valid 3-digit even numbers: "
            + obj.totalNumbers(digits)
        );
    }
}