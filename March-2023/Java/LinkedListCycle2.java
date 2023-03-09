/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
  // 142. Linked List Cycle II
 // two pointed approach
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){        
            slow=slow.next;
            fast=fast.next.next;
              // cycle found
            if(slow==fast) break;
         }
        if(slow!=fast) return null;
        ListNode temp = head;
          // starting node found if both match
        while(temp!=slow){
            temp=temp.next;
            slow=slow.next;
        }
            return temp;
    }
}
