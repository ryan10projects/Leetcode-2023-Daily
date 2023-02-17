/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode* left;
 *     TreeNode* right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
 * };
 */
 // 783. Minimum Distance Between BST Nodes
 // InOrder traversal since its a binary search tree
 // keep comparing older elements with new (difference) and save it
class Solution {
    int minVal = INT_MAX;
    TreeNode* prev = nullptr;
public:
    int minDiffInBST(TreeNode* root) {
        dfs(root);
        return minVal;
    }
    
    void dfs(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        
        dfs(root->left);
        
        if (prev != nullptr) {
            minVal = min(minVal, root->val - prev->val);
        }
        
        prev = root;
        dfs(root->right);
    }
};
