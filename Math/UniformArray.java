public class UniformArray {

    // Problem: Uniform Array
    // Platform: LeetCode
    // Approach: Counting Even and Odd Elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public boolean uniformArray(int[] nums1) {

        int odd = 0;
        int even = 0;

        for(int a : nums1){

            if(a % 2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }

        // Array is uniform if all elements
        // are either even or all are odd
        if(even == nums1.length || odd == nums1.length){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        UniformArray solution = new UniformArray();

        int[] nums1 = {2, 4, 6, 8};

        boolean result = solution.uniformArray(nums1);

        System.out.println("Answer: " + result);
    }
}