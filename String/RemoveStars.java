import java.util.*;

public class RemoveStars {

    // Problem: Removing Stars From a String
    // Platform: LeetCode
    // Approach: Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {

            if(ch == '*') {

                // Remove the most recent character
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {

                // Add normal character to stack
                stack.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        // Build the final string
        for(char ch : stack) {
            res.append(ch);
        }

        return res.toString();
    }

    public static void main(String[] args) {

        RemoveStars solution = new RemoveStars();

        String s = "leet**cod*e";

        String result = solution.removeStars(s);

        System.out.println("Result: " + result);
    }
}