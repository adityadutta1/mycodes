/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public ListNode reorderList(ListNode head) {
    if (head == null || head.next == null) return head;

    // Step 1: Find the middle of the list
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse the second half of the list
    ListNode secondHalf = slow.next;
    slow.next = null;  // Split the list into two halves

    ListNode prev = null;
    ListNode cur = secondHalf;
    while (cur != null) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    secondHalf = prev; // Now `secondHalf` points to the reversed list

    // Step 3: Merge the two halves
    ListNode firstHalf = head;
    while (secondHalf != null) {
        ListNode temp1 = firstHalf.next;
        ListNode temp2 = secondHalf.next;

        firstHalf.next = secondHalf; // Connect first half to second half
        secondHalf.next = temp1;      // Connect second half to the next node in the first half

        firstHalf = temp1;            // Move to the next node in the first half
        secondHalf = temp2;           // Move to the next node in the second half
    }

    return head; // Return the modified list
}

}
