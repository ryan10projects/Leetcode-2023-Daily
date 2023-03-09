/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 // 142. Linked List Cycle II
 // two pointed approach
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* slow=head, *fast=head;
        while (fast!=NULL && fast->next!=NULL) {
            slow=slow->next;
            fast=fast->next->next;
            // cycle found
            if(slow==fast) 
            {
                // reseting slow to head
                slow=head;
                // starting node found if both match
                while (slow != fast) {
                    slow=slow->next;
                    fast=fast->next;
                }
                return slow;
            }
        }
        return NULL;
    }
};
