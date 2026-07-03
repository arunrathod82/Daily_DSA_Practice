/*
Problem: Destination City
Platform: LeetCode
Approach: HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class DestinationCity {

    public static String destCity(
            List<List<String>> paths) {

        HashSet<String> set =
                new HashSet<>();

        // Store all source cities
        for(List<String> path : paths) {

            set.add(path.get(0));
        }

        // Destination city will never
        // appear as source city
        for(List<String> path : paths) {

            String destination =
                    path.get(1);

            if(!set.contains(destination)) {

                return destination;
            }
        }

        return "";
    }

    public static void main(String[] args) {

        List<List<String>> paths =
                Arrays.asList(
                        Arrays.asList(
                                "London",
                                "New York"
                        ),
                        Arrays.asList(
                                "New York",
                                "Lima"
                        ),
                        Arrays.asList(
                                "Lima",
                                "Sao Paulo"
                        )
                );

        String result =
                destCity(paths);

        System.out.println(
                "Destination City: "
                + result
        );
    }
}