// 662. Maximum Width of Binary Tree

 // Perform bfs

 // find max width by finding the left most index and right most index and then find the difference

 // push the remaining indexes by using the formula 2*index+1 for left node and +2 for right node. this way we will get the index number for left ans right node

class Solution {

public:

    typedef unsigned long long ll;

    int widthOfBinaryTree(TreeNode* root) {

        ll maxWidth = 0;

        queue<pair<TreeNode*, ll>> q;

        q.push({root,0});

        while(!q.empty()){

            int size = q.size();

            ll front = q.front().second;

            ll last = q.back().second;

            maxWidth = max(maxWidth, ((last)-(front))+1);

            while(size--){

                TreeNode* curr = q.front().first;

                ll index = q.front().second;

                q.pop();

                if(curr->left){

                    //get index of left node formula (2*index)+1 

                    q.push({curr->left, (2*index)+1});

                }

                if(curr->right){

                    q.push({curr->right, (2*index)+2});

                }

                

            }

        }

        return maxWidth;

    }

};
