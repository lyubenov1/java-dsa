package com.test.LinkedList.medium;

import com.test.LinkedList.*;
import com.test.LinkedList.easy.ReverseLinkedList.*;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;

        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast reaches the end, we need to remove the head node
        if (fast == null) return head.next;

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from the end
        slow.next = slow.next.next;

        return head;
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

    // Helper method to print a linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = arrayToList(arr);

        System.out.println("Original List:");
        printList(head);

        // Remove the 2nd node from the end (should remove '4')
        head = removeNthFromEnd(head, 2);

        System.out.println("List after removing 2nd node from end:");
        printList(head);
    }
}
