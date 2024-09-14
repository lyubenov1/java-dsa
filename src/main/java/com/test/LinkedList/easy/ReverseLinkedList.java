package com.test.LinkedList.easy;

import com.test.LinkedList.*;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};

        // Create the linked list from the array
        ListNode head = arrayToLinkedList(input);

        System.out.print("Original List: ");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Iterative solution
    private static ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }


    // Recursive solution
    /*
    private static ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }

    private static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
     */
}
