/*
Problem: Search Insert Position
Approach: Binary Search

We search for the target in the sorted array.
If the target is found, return its index.
If not found, return the position where it should be inserted.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class searchInsertPos {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        searchInsertPos sol = new searchInsertPos();

        int[] nums = {1,3,5,6};
        int target = 5;

        int result = sol.searchInsert(nums, target);

        System.out.println("Insert position: " + result);
    }
}