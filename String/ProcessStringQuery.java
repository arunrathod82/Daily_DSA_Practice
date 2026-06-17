/*
Problem: Process String Queries
Approach:
1. Forward pass -> calculate final length
2. Reverse traversal -> trace kth character

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class ProcessStringQuery {

    public static char processStr(String s, long k) {

        long length = 0;

        // Calculate final length
        for(char c : s.toCharArray()) {

            if(Character.isLetter(c)) {
                length++;
            }

            else if(c == '*') {

                if(length > 0) {
                    length--;
                }
            }

            else if(c == '#') {

                length *= 2;
            }

            else {

                // '%' reverse operation
                continue;
            }
        }

        // Invalid index
        if(k >= length) {
            return '.';
        }

        // Reverse processing
        for(int i = s.length() - 1;
            i >= 0;
            i--) {

            char c = s.charAt(i);

            // Duplicate operation
            if(c == '#') {

                length /= 2;

                if(k >= length) {
                    k -= length;
                }
            }

            // Reverse operation
            else if(c == '%') {

                k = length - 1 - k;
            }

            // Delete operation
            else if(c == '*') {

                length++;
            }

            // Normal character
            else {

                if(k == length - 1) {
                    return c;
                }

                length--;
            }
        }

        return '.';
    }

    public static void main(String[] args) {

        String s = "ab#c%";
        long k = 2;

        char result = processStr(s, k);

        System.out.println(
                "Character at Index "
                + k +
                " : "
                + result
        );
    }
}