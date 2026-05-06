/*
Problem: Robot Return to Origin
Platform: LeetCode
Approach: Coordinate Simulation
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for(char c : moves.toCharArray()) {

            if(c == 'U') {
                y++;
            }

            else if(c == 'D') {
                y--;
            }

            else if(c == 'R') {
                x++;
            }

            else {
                x--;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {

        String moves = "UDLR";

        boolean result = judgeCircle(moves);

        System.out.println("Returns to Origin: " + result);
    }
}