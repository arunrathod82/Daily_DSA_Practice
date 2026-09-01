import java.util.*;

public class CheckAllBinaryCodes {

    // Problem: Check If a String Contains All Binary Codes of Size K
    // Platform: LeetCode
    // Approach: Sliding Window + HashSet
    // Time Complexity: O(n * k)
    // Space Complexity: O(2^k)

    public boolean hasAllCodes(String s, int k) {

        // Number of binary combinations of length k
        int total = 1 << k;

        // If there are not enough characters,
        // it is impossible to contain all combinations.
        if(s.length() < k){
            return false;
        }

        HashSet<String> set = new HashSet<>();

        // Generate every substring of length k
        for(int i = 0; i <= s.length() - k; i++){

            String sub = s.substring(i, i + k);

            set.add(sub);
        }

        // If we found all 2^k combinations,
        // then every binary code exists.
        return set.size() == total;
    }

    public static void main(String[] args) {

        CheckAllBinaryCodes solution =
                new CheckAllBinaryCodes();

        String s = "00110110";
        int k = 2;

        boolean result =
                solution.hasAllCodes(s, k);

        System.out.println("Answer: " + result);
    }
}