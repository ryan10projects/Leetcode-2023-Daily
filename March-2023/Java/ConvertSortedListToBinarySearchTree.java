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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // 109. Convert Sorted List to Binary Search Tree
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // find middle, and have a pointer prev before middle to cut the array into halves 
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode center = new TreeNode(slow.val);
        // make sure the end of left half points to null
        prev.next=null;
        // since we already solved it for left and right tree, we can use recursion to solve the entire problem 
        center.left = sortedListToBST(head);
        // right half of ListNode 
        center.right = sortedListToBST(slow.next);
        return center;
    }
}
