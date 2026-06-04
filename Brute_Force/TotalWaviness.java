/*
Problem: Total Waviness
Approach: Check local peaks and valleys
Time Complexity: O(n * d)

n = range size
d = number of digits
*/

import java.util.*;

public class TotalWaviness {

    public static int totalWaviness(int num1, int num2) {

        int answer = 0;

        for(int x = num1; x <= num2; x++) {

            String s = String.valueOf(x);

            for(int i = 1; i < s.length() - 1; i++) {

                int curr = s.charAt(i) - '0';
                int left = s.charAt(i - 1) - '0';
                int right = s.charAt(i + 1) - '0';

                // Peak OR Valley
                if((curr > left && curr > right) ||
                   (curr < left && curr < right)) {

                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int num1 = 120;
        int num2 = 130;

        int result = totalWaviness(num1, num2);

        System.out.println("Total Waviness: " + result);
    }
}