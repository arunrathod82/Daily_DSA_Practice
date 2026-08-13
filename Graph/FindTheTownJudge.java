/*
Problem: Find the Town Judge
Platform: LeetCode
Approach: Indegree + Outdegree
Time Complexity: O(E + N)
Space Complexity: O(N)

E = number of trust relationships
N = number of people
*/

import java.util.*;

public class FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {

        int[] trusted = new int[n + 1];
        int[] trustedBy = new int[n + 1];

        // Count:
        // trusted[a]   = how many people person a trusts
        // trustedBy[b] = how many people trust person b
        for(int[] relation : trust) {

            int a = relation[0];
            int b = relation[1];

            trusted[a]++;
            trustedBy[b]++;
        }

        // Judge:
        // 1. Trusts nobody
        // 2. Is trusted by everyone else
        for(int person = 1; person <= n; person++) {

            if(trusted[person] == 0 &&
               trustedBy[person] == n - 1) {

                return person;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] trust = {
                {1, 3},
                {2, 3}
        };

        int result = findJudge(n, trust);

        System.out.println(
                "Town Judge: " + result
        );
    }
}