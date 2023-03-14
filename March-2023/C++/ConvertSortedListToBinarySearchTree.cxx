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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
// 109. Convert Sorted List to Binary Search Tree
// Since the ListNode are sorted, we find the middle node make it the root and recursively call left and right to make it a balanced bst
// Starting from the middle will help it make it a balanced bst
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head) return NULL;
        if(!head->next) return new TreeNode(head->val);
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = NULL;
        while(fast && fast->next){
            // find middle, and have a pointer prev before middle to cut the array into halves 
            prev = slow;
            slow=slow->next;
            fast=(fast->next)->next;
        }
        TreeNode* curr = new TreeNode(slow->val);
        // make sure the end of left half points to null
        prev->next=NULL;
        // since we already solved it for left and right tree, we can use recursion to solve the entire problem 
        curr->left = sortedListToBST(head);
        // right half of ListNode 
        curr->right = sortedListToBST(slow->next);
        return curr;
      }
};
