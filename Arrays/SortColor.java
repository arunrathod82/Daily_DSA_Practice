/*
Problem: Sort Colors
Platform: LeetCode
Approach: Dutch National Flag Algorithm
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class SortColor {

    public static void sortColors(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while(mid <= high){

            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }

            else if(nums[mid] == 1){
                mid++;
            }

            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);

        System.out.println("Sorted Colors: " + Arrays.toString(nums));
    }
}