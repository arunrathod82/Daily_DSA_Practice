/*
Problem: Remove Duplicates from Sorted Array
Approach: Two Pointer Technique

We maintain two pointers:
k → position of last unique element
i → scans the array

If nums[i] is different from nums[k],
we move k forward and place nums[i] at that position.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class removeDuplicates {

    public int removeDuplicatesElement(int[] nums) {

        int k = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }

    public static void main(String[] args) {

        removeDuplicates sol = new removeDuplicates();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = sol.removeDuplicatesElement(nums);

        System.out.println("Number of unique elements: " + k);

        System.out.print("Array after removing duplicates: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}