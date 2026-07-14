/*
Problem: Set Mismatch
Platform: LeetCode
Approach: Cyclic Sort
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class SetMismatch {

    public static int[] findErrorNums(
            int[] nums) {

        int i = 0;

        // Cyclic Sort
        while(i < nums.length) {

            int correct =
                    nums[i] - 1;

            if(nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }

            else {

                i++;
            }
        }

        // Find duplicate and missing number
        for(int j = 0;
            j < nums.length;
            j++) {

            if(nums[j] != j + 1) {

                return new int[]{
                        nums[j],
                        j + 1
                };
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2,4};

        int[] result =
                findErrorNums(nums);

        System.out.println(
                "Duplicate = "
                + result[0]
        );

        System.out.println(
                "Missing = "
                + result[1]
        );
    }
}