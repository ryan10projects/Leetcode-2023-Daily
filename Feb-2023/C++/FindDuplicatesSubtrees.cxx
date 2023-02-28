// 652. Find Duplicate Subtrees

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

	public:	string turnintosubstring(TreeNode * root, vector<TreeNode*> & res, unordered_map<string, int> & map) {

		// add null values too, to make sure there they have the right structure even if the strings match

		if (root == nullptr) return "NULL";

		// create a string starting from the root 

		string s = to_string(root->val) + "," + turnintosubstring(root->left, res, map) + "," + turnintosubstring(root->right, res, map);

		// if theres one duplicage

		if (map[s] == 1) {

			res.push_back(root);

		} 

          // no else for duplicates

		 map[s]++;		

		return s;

	}

	vector<TreeNode*> findDuplicateSubtrees(TreeNode * root) {

		vector<TreeNode*> res;

		if (root == nullptr) return res;

		unordered_map<string, int> map;

		turnintosubstring(root, res, map);

		return res;

	}

};
