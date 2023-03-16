

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
  // 106. Construct Binary Tree from Inorder and Postorder Traversal
//we fetch the post order end first and make it the root. Then traverse the inorder array till the root is found, if found divide it into two halves, left half for root.left and right half for root.right and repeat the process
class Solution {
public:
    TreeNode* solve(vector<int>& inorder, vector<int>& postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return nullptr;
        }
        // end of postorder will always be the root
        TreeNode* root = new TreeNode(postorder[postEnd]);
        int i = 0;
        for (; i < inorder.size(); i++) {
            if (inorder[i] == root->val) {
                break;
            }
        }
        // fetch left and right subarray

        int left = i - inStart;
        int right = inEnd - i;
        root->left = solve(inorder, postorder, inStart, i - 1, postStart, postStart + left - 1);
        root->right = solve(inorder, postorder, i + 1, inEnd, postEnd - right, postEnd - 1);
       return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return solve(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1);
    }
};
