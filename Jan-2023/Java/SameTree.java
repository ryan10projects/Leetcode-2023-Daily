100. Same Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }f
 * }
 */
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		//both TreeNodes are null
		if (p == null && q == null) return true;
		//any one TreeNode is null
		else if (p == null || q == null) return false;
		//left and right TreeNode are not same in value
		else if (p.val != q.val) return false;
		else {
			//check for left and right branch
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
