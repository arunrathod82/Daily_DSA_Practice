/*
Problem: Fair Candy Swap
Platform: LeetCode
Approach: Math + HashSet
Time Complexity: O(n + m)
Space Complexity: O(m)
*/

import java.util.*;

public class FairCandySwap {

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumAlice = 0;

        for(int candy : aliceSizes) {
            sumAlice += candy;
        }

        int sumBob = 0;

        for(int candy : bobSizes) {
            sumBob += candy;
        }

        int diff = (sumAlice - sumBob) / 2;

        HashSet<Integer> set = new HashSet<>();

        for(int candy : bobSizes) {
            set.add(candy);
        }

        for(int a : aliceSizes) {

            int b = a - diff;

            if(set.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[] aliceSizes = {1, 1};
        int[] bobSizes = {2, 2};

        int[] result = fairCandySwap(aliceSizes, bobSizes);

        System.out.println("Candy Swap: " + Arrays.toString(result));
    }
}