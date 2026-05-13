/*
Problem: Make The String Great
Platform: LeetCode
Approach: Stack
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class MakeTheStringGreat {

    public static String makeGood(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(!stack.isEmpty() &&
               Math.abs(stack.peek() - c) == 32) {

                stack.pop();
            }

            else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        String s = "leEeetcode";

        String result = makeGood(s);

        System.out.println("Good String: " + result);
    }
}