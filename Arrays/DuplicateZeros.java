/*
Problem: Duplicate Zeros
Platform: LeetCode
Approach: Copy Array Simulation
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {

        int n = arr.length;
        int[] copyArray = arr.clone();

        int i = 0;
        int j = 0;

        while(i < n) {

            if(copyArray[j] == 0) {

                arr[i] = 0;
                i++;

                if(i < n) {
                    arr[i] = 0;
                    i++;
                }
            }
            else {
                arr[i] = copyArray[j];
                i++;
            }

            j++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

        duplicateZeros(arr);

        System.out.println("Array after duplicating zeros: " + Arrays.toString(arr));
    }
}