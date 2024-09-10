package com.test.LinkedList.easy;

import com.test.LinkedList.easy.ReverseLinkedList.*;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // Create a dummy node as the starting point
        ListNode handler = head; // Handler will help us link nodes together

        while (l1 != null && l2 != null) { // Traverse through both lists while neither is null
            if (l1.val <= l2.val) { // If the value in l1 is less than or equal to the value in l2
                handler.next = l1; // Point handler to the smaller node (l1 in this case)
                l1 = l1.next; // Move l1 to the next node
            } else { // Otherwise, point handler to the node in l2
                handler.next = l2;
                l2 = l2.next; // Move l2 to the next node
            }
            handler = handler.next; // Move handler to the next node in the merged list
        }

        // If one list is exhausted, link the remaining part of the other list
        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        // Return the next node after the dummy head (i.e., the real head of the merged list)
        return head.next;
    }

    /* Recursive Solution
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
     */

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] list1Arr = {1, 2, 4};
        int[] list2Arr = {1, 3, 4};

        ListNode list1 = arrayToList(list1Arr);
        ListNode list2 = arrayToList(list2Arr);

        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedList);
    }
}