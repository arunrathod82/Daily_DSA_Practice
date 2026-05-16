/*
Problem: Add to Array-Form of Integer
Platform: LeetCode
Approach: Simulate Addition from End
Time Complexity: O(max(n, logk))
Space Complexity: O(max(n, logk))
*/

import java.util.*;

public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();

        int i = num.length - 1;

        while(i >= 0 || k > 0) {

            if(i >= 0) {
                k += num[i--];
            }

            ans.add(k % 10);

            k /= 10;
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] num = {1, 2, 0, 0};
        int k = 34;

        List<Integer> result = addToArrayForm(num, k);

        System.out.println("Array Form Sum: " + result);
    }
}