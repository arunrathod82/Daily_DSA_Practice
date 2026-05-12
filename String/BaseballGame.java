/*
Problem: Baseball Game
Platform: LeetCode
Approach: Stack Simulation
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for(String op : operations) {

            if(op.equals("C")) {

                int removed = stack.pop();
                total -= removed;
            }

            else if(op.equals("D")) {

                int doubled = stack.peek() * 2;

                stack.push(doubled);

                total += doubled;
            }

            else if(op.equals("+")) {

                int top = stack.pop();
                int second = stack.peek();

                int sum = top + second;

                stack.push(top);
                stack.push(sum);

                total += sum;
            }

            else {

                int num = Integer.parseInt(op);

                stack.push(num);

                total += num;
            }
        }

        return total;
    }

    public static void main(String[] args) {

        String[] operations = {"5", "2", "C", "D", "+"};

        int result = calPoints(operations);

        System.out.println("Total Score: " + result);
    }
}