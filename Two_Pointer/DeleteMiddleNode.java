/*
Problem: Delete the Middle Node of a Linked List
Platform: LeetCode
Approach:
1. Fast & Slow Pointer
2. Track previous node
3. Delete middle node

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class DeleteMiddleNode {

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

    public static ListNode deleteMiddle(
            ListNode head) {

        // Only one node
        if(head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // Find middle node
        while(fast != null &&
              fast.next != null) {

            prev = slow;

            fast = fast.next.next;

            slow = slow.next;
        }

        // Delete middle
        prev.next = slow.next;

        return head;
    }

    // Print linked list
    public static void printList(
            ListNode head) {

        while(head != null) {

            System.out.print(
                    head.val
                    +
                    " -> "
            );

            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
        Linked List:
        1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

        Middle node = 7
        */

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(
                                                7,
                                                new ListNode(
                                                        1,
                                                        new ListNode(
                                                                2,
                                                                new ListNode(6)
                                                        )
                                                )
                                        )
                                )
                        )
                );

        System.out.println(
                "Original Linked List:"
        );

        printList(head);

        head = deleteMiddle(head);

        System.out.println(
                "After Deleting Middle:"
        );

        printList(head);
    }
}