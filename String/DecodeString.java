/*
Problem: Decode String
Platform: LeetCode
Approach: Stack
Time Complexity: O(n * k)
Space Complexity: O(n)
*/

import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int k = 0;

        for(char c : s.toCharArray()) {

            if(Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }

            if(c == '[') {
                numStack.push(k);
                k = 0;
                strStack.push(String.valueOf(c));
                continue;
            }

            if(c != ']') {
                strStack.push(String.valueOf(c));
                continue;
            }

            StringBuilder temp = new StringBuilder();

            while(!strStack.peek().equals("[")) {
                temp.insert(0, strStack.pop());
            }

            strStack.pop();

            StringBuilder replacement = new StringBuilder();
            int count = numStack.pop();

            for(int i = 0; i < count; i++) {
                replacement.append(temp);
            }

            strStack.push(replacement.toString());
        }

        StringBuilder result = new StringBuilder();

        while(!strStack.isEmpty()) {
            result.insert(0, strStack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "3[a2[c]]";

        String result = decodeString(s);

        System.out.println("Decoded String: " + result);
    }
}