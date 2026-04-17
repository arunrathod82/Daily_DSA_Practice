/*
Problem: Asteroid Collision
Platform: LeetCode
Approach: Stack Simulation
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(int asteroid : asteroids) {

            boolean destroyed = false;

            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {

                int sum = stack.peek() + asteroid;

                if(sum < 0) {
                    stack.pop();
                }

                else if(sum > 0) {
                    destroyed = true;
                    break;
                }

                else {
                    destroyed = true;
                    stack.pop();
                    break;
                }
            }

            if(!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] asteroids = {5, 10, -5};

        int[] result = asteroidCollision(asteroids);

        System.out.println("Remaining Asteroids: " + Arrays.toString(result));
    }
}