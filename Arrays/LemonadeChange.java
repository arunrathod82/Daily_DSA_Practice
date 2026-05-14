/*
Problem: Lemonade Change
Platform: LeetCode
Approach: Greedy
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {

        int count5 = 0;
        int count10 = 0;

        for(int i = 0; i < bills.length; i++) {

            if(bills[i] == 5) {
                count5++;
            }

            else if(bills[i] == 10) {

                if(count5 > 0) {
                    count5--;
                    count10++;
                }

                else {
                    return false;
                }
            }

            else {

                if(count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                }

                else if(count5 >= 3) {
                    count5 -= 3;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] bills = {5, 5, 5, 10, 20};

        boolean result = lemonadeChange(bills);

        System.out.println("Can Provide Change: " + result);
    }
}