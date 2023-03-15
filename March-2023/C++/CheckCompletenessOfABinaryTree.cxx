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
 // 958. Check Completeness of a Binary Tree
class Solution {
public:
    bool isCompleteTree(TreeNode* root) {
        queue<TreeNode*> q;
        bool isnull = false;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            while(size-->0){
                TreeNode* t = q.front();
                q.pop();
                //check if node is null
                if(t==nullptr){
                    isnull=true;
                }
                else{
                    // check if previous node is null (all nodes should be far left in a complete binary tree)
                    if(isnull==true){
                        return false;
                    }
                    q.push(t->left);
                    q.push(t->right);
                }
            }
       }
        return true;
    }
};
