/*
Problem: Maximum Twin Sum of a Linked List
Platform: LeetCode
Approach:
1. Find middle of linked list
2. Reverse second half
3. Calculate twin sums

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaximumTwinSum {

    // Definition for singly-linked list
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,
                 ListNode next) {

            this.val = val;
            this.next = next;
        }
    }

    public static int pairSum(ListNode head) {

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null &&
              fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = null;

        while(curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        // Calculate twin sums
        ListNode first = head;
        ListNode second = prev;

        int maxSum = 0;

        while(first != null &&
              second != null) {

            maxSum = Math.max(
                    maxSum,
                    first.val + second.val
            );

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        /*
        Linked List:
        5 -> 4 -> 2 -> 1

        Twin pairs:
        (5,1) = 6
        (4,2) = 6
        */

        ListNode head =
                new ListNode(
                        5,
                        new ListNode(
                                4,
                                new ListNode(
                                        2,
                                        new ListNode(1)
                                )
                        )
                );

        int result = pairSum(head);

        System.out.println(
                "Maximum Twin Sum: "
                + result
        );
    }
}