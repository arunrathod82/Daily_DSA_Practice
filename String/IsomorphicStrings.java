/*
Problem: Isomorphic Strings
Platform: LeetCode
Approach: Two-Way Character Mapping
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class IsomorphicStrings {

    public static boolean isIsomorphic(
            String s,
            String t) {

        char[] mapST = new char[256];
        char[] mapTS = new char[256];

        for(int i = 0; i < s.length(); i++) {

            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // New mapping
            if(mapST[chS] == 0 &&
               mapTS[chT] == 0) {

                mapST[chS] = chT;
                mapTS[chT] = chS;
            }

            // Existing mapping check
            else {

                if(mapST[chS] != chT ||
                   mapTS[chT] != chS) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        boolean result =
                isIsomorphic(s, t);

        System.out.println(
                "Is Isomorphic: "
                + result
        );
    }
}