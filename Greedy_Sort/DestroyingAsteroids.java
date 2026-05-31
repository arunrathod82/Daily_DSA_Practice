/*
Problem: Destroying Asteroids
Platform: LeetCode 2126
Approach: Greedy + Sorting
Time Complexity: O(n log n)
Space Complexity: O(1) (excluding sorting space)
*/

import java.util.*;

public class DestroyingAsteroids {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        long currMass = mass;

        for(int asteroid : asteroids) {

            if(asteroid > currMass) {
                return false;
            }

            currMass += asteroid;
        }

        return true;
    }

    public static void main(String[] args) {

        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};

        boolean result = asteroidsDestroyed(mass, asteroids);

        System.out.println("Can Destroy All Asteroids: " + result);
    }
}