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


// Algorithm 
// create two list and make all the smaller elememts in list1 and bigger in list2 then combine
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode list1P = list1;
        ListNode list2P = list2;
        while(head!=null){
            if(head.val<x){
                list1P.next = head;
                list1P = list1P.next;
            }
            else{
                list2P.next = head;
                list2P = list2P.next;
            }
            head = head.next;
         }
        list2P.next = null;
        list1P.next = list2.next;
        return list1.next;
    }
}
