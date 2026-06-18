/*
Problem: Angle Between Hands of a Clock
Platform: LeetCode
Approach: Math
Time Complexity: O(1)
Space Complexity: O(1)
*/

import java.util.*;

public class AngleClock {

    public static double angleClock(
            int hour,
            int minutes) {

        // Minute hand angle
        double minAngle =
                minutes * 6;

        // Hour hand angle
        double hourAngle =
                (hour * 30)
                +
                (minutes * 0.5);

        // Difference
        double diff =
                Math.abs(
                        minAngle - hourAngle
                );

        // Smaller angle
        double angle =
                Math.min(
                        diff,
                        360 - diff
                );

        return angle;
    }

    public static void main(String[] args) {

        int hour = 3;
        int minutes = 30;

        double result =
                angleClock(hour, minutes);

        System.out.println(
                "Angle Between Clock Hands: "
                + result
        );
    }
}