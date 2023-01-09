

//144. Binary Tree Preorder Traversal

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

class Solution {

public:

    vector<int> preorderTraversal(TreeNode* root) {

        vector<int> list;

        dfs(root,list);

        return list;

    }

    

  void dfs(TreeNode* root, vector<int>& ls){

        if(root==nullptr) return; //nothing to add so return;

        //preorder traversal: root,left,right

        ls.push_back(root->val); //add root first

        dfs(root->left,ls); //left branch

        dfs(root->right,ls); //right branch 

        

      }

};
