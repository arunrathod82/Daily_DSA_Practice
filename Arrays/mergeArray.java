/*
Problem: Merge Sorted Array
Approach: Two Pointer (from end)
Time Complexity: O(m+n)
Space Complexity: O(1)
*/

import java.util.Arrays;
class mergeArray {
     public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        int m = 4;
        int n = 3;

        int[] nums1 = {1,2,4,5,0,0,0};
        int[] nums2 = {3,6,7};

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}