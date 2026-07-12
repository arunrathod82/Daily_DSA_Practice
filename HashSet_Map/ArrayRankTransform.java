/*
Problem: Rank Transform of an Array
Platform: LeetCode
Approach: Sorting + HashMap
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

public class ArrayRankTransform {

    public static int[] arrayRankTransform(
            int[] arr) {

        // Copy original array
        int[] temp = Arrays.copyOf(
                arr,
                arr.length
        );

        // Sort copied array
        Arrays.sort(temp);

        // Map each unique number to its rank
        HashMap<Integer, Integer> rankMap =
                new HashMap<>();

        int rank = 1;

        for(int num : temp) {

            if(!rankMap.containsKey(num)) {

                rankMap.put(num, rank);

                rank++;
            }
        }

        // Replace each element with its rank
        for(int i = 0;
            i < arr.length;
            i++) {

            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {40, 10, 20, 30};

        int[] result =
                arrayRankTransform(arr);

        System.out.println(
                "Rank Transformed Array: "
                + Arrays.toString(result)
        );
    }
}