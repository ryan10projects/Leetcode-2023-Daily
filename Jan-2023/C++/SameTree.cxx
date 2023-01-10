// 100. Same Tree

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
class Solution
{
  public:
	bool isSameTree(TreeNode *p, TreeNode *q)
	{
		//both treenode are null
		if (p == nullptr && q == nullptr)
		{
			return true;
		}
		//anyone of them is null, so it means they are not the same
		if (p == nullptr || q == nullptr)
		{
			return false;
		}
		//both of them have different values
		else if (p->val != q->val)
		{
			return false;
		}
       //check left branch and also another revursive call for right branch
		return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}
};
