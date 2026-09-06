// Problem: Find Minimum in Rotated Sorted Array
// Platform: LeetCode
// Approach: Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)

public class FindMin {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // Find the middle index
            int mid = left + (right - left) / 2;

            /*
             * If nums[mid] > nums[right],
             * the minimum must be on the right side.
             */
            if (nums[mid] > nums[right]) {

                left = mid + 1;

            } else {

                /*
                 * nums[mid] <= nums[right]
                 * means mid could itself be the minimum,
                 * so we keep mid by doing right = mid.
                 */
                right = mid;
            }
        }

        // left == right, so this index contains the minimum
        return nums[left];
    }

    public static void main(String[] args) {

        FindMin obj = new FindMin();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Minimum element: " + obj.findMin(nums));
    }
}