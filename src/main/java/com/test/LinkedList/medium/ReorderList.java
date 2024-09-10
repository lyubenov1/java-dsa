package com.test.LinkedList.medium;

import com.test.LinkedList.easy.ReverseLinkedList.*;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list using two pointers
        ListNode p1 = head; // Slow pointer, moves one step at a time
        ListNode p2 = head; // Fast pointer, moves two steps at a time
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;   // Move p1 one step
            p2 = p2.next.next; // Move p2 two steps
        }
        // At the end of the loop, p1 will be at the middle of the list

        // Step 2: Reverse the second half of the list (starting from p1.next)
        ListNode preMiddle = p1; // p1 is the node before the second half
        ListNode preCurrent = p1.next; // Start of the second half of the list

        while (preCurrent != null && preCurrent.next != null) {
            // Move the current node to the front of the second half
            ListNode current = preCurrent.next; // Current node that we want to move
            preCurrent.next = current.next; // Skip the current node
            current.next = preMiddle.next; // Insert the current node right after the middle
            preMiddle.next = current; // Update preMiddle's next pointer to point to the new node
        }
        // After this loop, the second half of the list is reversed

        // Step 3: Reorder the list by alternating nodes from first and second halves
        p1 = head; // Reset p1 to the start of the list
        p2 = preMiddle.next; // Start of the reversed second half
        while (p1 != preMiddle) { // Continue until p1 reaches the middle
            preMiddle.next = p2.next; // Skip p2 (from second half) in the middle list
            p2.next = p1.next; // Insert p2 after p1
            p1.next = p2; // Link p1 to p2
            p1 = p2.next; // Move p1 to the next node
            p2 = preMiddle.next; // Move p2 to the next node in the second half
        }
        // After this loop, the list will be reordered as required
    }

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
        int[] arr = {1, 2, 3, 4};
        ListNode head = arrayToList(arr);

        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        System.out.print("Reordered List: ");
        printList(head);
    }

}