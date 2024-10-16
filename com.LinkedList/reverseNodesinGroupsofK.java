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
     public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (true) {
            ListNode kth = getKth(prev, k);
            
            if (kth == null) {
                break;
            }
            
            ListNode nextGroup = kth.next;
            
            // Reverse the current group
            ListNode cur = prev.next;
            ListNode prevNode = kth.next;
            
            while (cur != nextGroup) {
                ListNode nextNode = cur.next;
                cur.next = prevNode;
                prevNode = cur;
                cur = nextNode;
            }
            
            // Connect the reversed group
            ListNode tail = prev.next;
            prev.next = kth;
            tail.next = nextGroup;
            
            // Move prev to the last node of the reversed group
            prev = tail;
        }
        
        return dummy.next;
    }
    
    private ListNode getKth(ListNode start, int k) {
        ListNode ptr = start;
        for (int i = 0; i < k; i++) {
            if (ptr == null) {
                return null;
            }
            ptr = ptr.next;
        }
        return ptr;
    }

}
/**

creating a dummy node  for making easier for tracking head and prev 
ListNode dummy= new ListNode(-1);
dummy.next=head;
prev= dummy 



finding if k nodes are  still available ?  ->


            if available then save  a pointer in k+1 th node 

            now  
            
            use the reversal logic here 


            if(cur.next !=null )
            nextNode =cur.next 
            cur.next=prev
            prev=cur 
            cur=nextNode



            ** now  connecting the first node of a section of k nodes to k+1 node we saved in the starting 


if no then-> return dummy.next

 */
