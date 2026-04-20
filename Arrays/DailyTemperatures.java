/*
Problem: Daily Temperatures
Platform: LeetCode
Approach: Monotonic Stack
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int popIndex = stack.pop();
                result[popIndex] = i - popIndex;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = dailyTemperatures(temperatures);

        System.out.println("Days to Wait: " + Arrays.toString(result));
    }
}