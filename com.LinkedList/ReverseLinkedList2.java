public class ReverseLinkedList2 {

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
    // Function to reverse the sublist within the linked list
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        // If the list is empty or left position is the same as right, return the original list
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to handle edge case when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node just before the left position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Current node is the node at left position
        ListNode curr = prev.next;
        //reversing the  list and adjusting pointers
        //******* */
// prev ->  curr  ->   <- nextNode

        curr.next=nextNode.next

        // Reverse the portion of the linked list between left and right positions
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Return the updated head of the linked list
        return dummy.next;
    }
}

