/*
Problem: Earliest Finish Time
Approach: Greedy Simulation
Time Complexity: O(n + m)
Space Complexity: O(1)
*/

import java.util.*;

public class EarliestFinishTime {

    public static int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int bestAnswer = Integer.MAX_VALUE;

        // Earliest land ride finish
        int earliestLandRide = Integer.MAX_VALUE;

        for(int i = 0; i < landStartTime.length; i++) {

            int finish =
                    landStartTime[i] +
                    landDuration[i];

            earliestLandRide =
                    Math.min(earliestLandRide,
                             finish);
        }

        // Land -> Water
        for(int i = 0; i < waterStartTime.length; i++) {

            int start =
                    Math.max(earliestLandRide,
                             waterStartTime[i]);

            int finish =
                    start + waterDuration[i];

            bestAnswer =
                    Math.min(bestAnswer,
                             finish);
        }

        // Earliest water ride finish
        int earliestWaterRide =
                Integer.MAX_VALUE;

        for(int i = 0; i < waterStartTime.length; i++) {

            int finish =
                    waterStartTime[i] +
                    waterDuration[i];

            earliestWaterRide =
                    Math.min(earliestWaterRide,
                             finish);
        }

        // Water -> Land
        for(int i = 0; i < landStartTime.length; i++) {

            int start =
                    Math.max(earliestWaterRide,
                             landStartTime[i]);

            int finish =
                    start + landDuration[i];

            bestAnswer =
                    Math.min(bestAnswer,
                             finish);
        }

        return bestAnswer;
    }

    public static void main(String[] args) {

        int[] landStartTime = {1, 5};
        int[] landDuration = {4, 3};

        int[] waterStartTime = {2, 6};
        int[] waterDuration = {2, 1};

        int result = earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration
        );

        System.out.println(
                "Earliest Finish Time: " + result
        );
    }
}
