/*
Problem: Find All Numbers Disappeared in an Array
Platform: LeetCode
Approach: Mark visited indices using negative sign
Time Complexity: O(n)
Space Complexity: O(1) excluding output list
*/

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if(nums[index] < 0) {
                continue;
            }
            else {
                nums[index] = -nums[index];
            }
        }

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> result = findDisappearedNumbers(nums);

        System.out.println("Disappeared Numbers: " + result);
    }
}