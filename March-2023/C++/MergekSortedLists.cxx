/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 // 23. Merge k Sorted Lists
class Solution {
	public:
	// function to sort, we need to add cmp function if datatype is ListNode
	struct cmp {
		bool operator()(ListNode * a, ListNode * b) {
			return a->val > b->val;
		}
	};
	ListNode * mergeKLists(vector<ListNode*> & lists) {
		priority_queue<ListNode *, vector<ListNode*>, cmp> pq;
		for (ListNode * l : lists) {
			// adding the head ONLY from every every list of linked list
			if (l) {
				pq.push(l);
			}
		}
		ListNode * head = new ListNode(0);
		ListNode * tail = head;
		while (!pq.empty()) {
			// remove the first head we got and attach it at the start
			tail->next = pq.top();
			pq.pop();
			// move to the next node
			tail = tail->next;
			// check if the next node is empty or not (the head might be the smallest but the elements connected to the head are still not checked, so we keep adding all the elements till null)
			if (tail->next) {
				pq.push(tail->next);
			}
		}
		return head->next;

	}
};
