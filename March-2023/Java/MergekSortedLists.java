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
  // 23. Merge k Sorted Lists
class Solution {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		// we need to add cmp function if datatype is ListNode
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (l1, l2)->(l1.val - l2.val));
		for (ListNode x : lists) {
			// adding the head ONLY from every every list of linked list
			if (x != null) {
				pq.offer(x);
			}
		}

		ListNode head = new ListNode(0);
		ListNode tail = head;
		while (!pq.isEmpty()) {
			// remove the first head we got and attach it at the start
			tail.next = pq.poll();
			// move to the next node
			tail = tail.next;
				// check if the next node is empty or not (the head might be the smallest but the elements connected to the head are still not checked, so we keep adding all the elements till null)
			if (tail.next != null) {
				pq.offer(tail.next);
			}
		}
		return head.next;
	}
}
