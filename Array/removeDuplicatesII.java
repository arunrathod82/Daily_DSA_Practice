/*
Problem: Remove Duplicates from Sorted Array II

Approach: Two Pointer Technique

We allow each element to appear at most twice.
We maintain a pointer k which represents the position
to place the next valid element.

If k < 2 → always insert element
Else check if current element > nums[k-2]
If true → insert element.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class removeDuplicatesII {

    public int removeDuplicates(int[] nums) {

        int k = 0;

        for(int x : nums){
            if(k < 2 || x > nums[k-2]){
                nums[k] = x;
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        removeDuplicatesII sol = new removeDuplicatesII();

        int[] nums = {1,1,1,2,2,3};

        int k = sol.removeDuplicates(nums);

        System.out.println("Number of valid elements: " + k);

        System.out.print("Array after removing duplicates: ");

        for(int i = 0; i < k; i++){
            System.out.print(nums[i] + " ");
        }
    }
}