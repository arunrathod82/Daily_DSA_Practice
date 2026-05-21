/*
Problem: Find the Length of the Longest Common Prefix
Platform: LeetCode
Approach: Store all prefixes of arr1 in HashSet
Time Complexity: O(n*d + m*d)
Space Complexity: O(n*d)

where d = number of digits
*/

import java.util.*;

public class LongestCommonPrefixLength {

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        // Store all prefixes from arr1
        for(int num : arr1) {

            while(num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int maxLength = 0;

        // Check prefixes from arr2
        for(int num : arr2) {

            while(num > 0) {

                if(set.contains(num)) {

                    maxLength = Math.max(
                            maxLength,
                            String.valueOf(num).length()
                    );

                    break;
                }

                num /= 10;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};

        int result = longestCommonPrefix(arr1, arr2);

        System.out.println("Longest Common Prefix Length: " + result);
    }
}