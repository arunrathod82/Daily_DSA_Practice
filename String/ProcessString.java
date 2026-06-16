/*
Problem: Process String With Special Characters
Approach: StringBuilder Simulation
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class ProcessString {

    public static String processStr(String s) {

        StringBuilder result =
                new StringBuilder();

        for(char c : s.toCharArray()) {

            // Normal character
            if(Character.isLetter(c)) {

                result.append(c);
            }

            else {

                // Remove last character
                if(c == '*') {

                    if(result.length() > 0) {

                        result.deleteCharAt(
                                result.length() - 1
                        );
                    }
                }

                // Duplicate string
                else if(c == '#') {

                    result.append(
                            result.toString()
                    );
                }

                // Reverse string
                else {

                    result.reverse();
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "ab#c*d";

        String result = processStr(s);

        System.out.println(
                "Processed String: "
                + result
        );
    }
}