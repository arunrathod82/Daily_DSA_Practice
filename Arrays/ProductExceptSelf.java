/*
Problem: Product of Array Except Self
Platform: LeetCode
Approach: Prefix Product + Suffix Product
Time Complexity: O(n)
Space Complexity: O(1) (excluding output array)
*/

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int leftProd = 1;

        for(int i = 0; i < n; i++){
            answer[i] = leftProd;
            leftProd = leftProd * nums[i];
        }

        int rightProd = 1;

        for(int i = n - 1; i >= 0; i--){
            answer[i] = answer[i] * rightProd;
            rightProd = rightProd * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        int[] result = productExceptSelf(nums);

        System.out.println("Result: " + Arrays.toString(result));
    }
}