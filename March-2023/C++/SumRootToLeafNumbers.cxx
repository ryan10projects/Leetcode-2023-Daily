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
// 129. Sum Root to Leaf Numbers
class Solution {
public:
    int solve(TreeNode*root, int curr){
        if(!root) return 0;
        // node 1
        // node 2
        // 1*10=10
        // 10+2(value of node 2)
        //12
        curr = (curr*10)+root->val;
        if(root->left==nullptr && root->right==nullptr) return curr;
        // get ths curr for left node and right node
        int left_node = solve(root->left,curr);
        int right_node = solve(root->right,curr);
        // adds all the left and right node recursively
        return left_node+right_node;
     }    
    int sumNumbers(TreeNode* root) {
        return solve(root,0);        
    }
};
