/*
Problem: Last Stone Weight
Platform: LeetCode
Approach: Max Heap (PriorityQueue)
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

package Heap;

import java.util.*;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            heap.add(stone);
        }

        while(heap.size() > 1){

            int first = heap.poll();
            int second = heap.poll();

            if(first != second){
                heap.add(first - second);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }

    public static void main(String[] args){

        int[] stones = {2,7,4,1,8,1};

        int result = lastStoneWeight(stones);

        System.out.println("Last Stone Weight: " + result);
    }
}