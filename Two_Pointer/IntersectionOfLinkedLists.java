/*
Problem: Intersection of Two Linked Lists
Platform: LeetCode
Approach: Two Pointers
Time Complexity: O(n + m)
Space Complexity: O(1)
*/

import java.util.*;

public class IntersectionOfLinkedLists {

    // Definition for singly-linked list
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(
            ListNode headA,
            ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        // Traverse both lists
        while(p1 != p2) {

            p1 = (p1 == null)
                    ? headB
                    : p1.next;

            p2 = (p2 == null)
                    ? headA
                    : p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {

        /*
                8 -> 4 -> 5
               /          \
        4 -> 1             null
               \
                5 -> 6 -> 1
        */

        // Common part
        ListNode common =
                new ListNode(8);

        common.next =
                new ListNode(4);

        common.next.next =
                new ListNode(5);

        // List A
        ListNode headA =
                new ListNode(4);

        headA.next =
                new ListNode(1);

        headA.next.next = common;

        // List B
        ListNode headB =
                new ListNode(5);

        headB.next =
                new ListNode(6);

        headB.next.next =
                new ListNode(1);

        headB.next.next.next = common;

        ListNode result =
                getIntersectionNode(
                        headA,
                        headB
                );

        if(result != null) {

            System.out.println(
                    "Intersection Node Value: "
                    + result.val
            );
        }

        else {

            System.out.println(
                    "No Intersection"
            );
        }
    }
}