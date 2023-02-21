// 103. Binary Tree Zigzag Level Order Traversal

// Keep a toggle boolean value, to reverse the elements while transversing for making a zigzag pattern

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

    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {

        if(root==nullptr){

          return {};

        }

        bool reversecheck=true;

        vector<vector<int>> res;

        queue<TreeNode*> q;

        q.push(root);

        while(!q.empty()){

            int size = q.size();

            vector<int> ls;

            while(size-->0){

                TreeNode* x = q.front();

                q.pop();

                ls.push_back(x->val);

                if(x->left!=nullptr){

                    q.push(x->left);

                }

                if(x->right!=nullptr){

                    q.push(x->right); 

                }            

            }

            if(!reversecheck){

               reverse(ls.begin(),ls.end());

             }

                res.push_back(ls);

                reversecheck=!reversecheck;

        }

        return res;

    }

};
