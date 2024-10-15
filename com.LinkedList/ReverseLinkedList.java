public class ReverseLinkedList {
  class Solution {
        public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode current = head;

            ListNode nextNode = current.next;


            while (nextNode != null) {
                ListNode temp = nextNode.next;
                nextNode.next = current;

                current = nextNode;
                nextNode = temp;
            }

            head.next = null;  // At the end, the original head (l1) should point to null
            return current;    // current is now the new head of the reversed list
        }
    }

