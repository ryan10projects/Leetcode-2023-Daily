// 101. Symmetric Tree
// just make sure the recrusion for left and right comparison both return true using &&
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
 *     }
 * }
 */
class Solution {
    public boolean isTrue(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;        
        if(left.val!=right.val) return false;       
        return isTrue(left.left, right.right) && isTrue(left.right,right.left);       
    }
     
    public boolean isSymmetric(TreeNode root) {
        // if only one node is present
        if(root.left==null && root.right==null) return true;
      // if any one is null its not a mirror
           if(root.left==null || root.right==null) return false;
        if(isTrue(root.left,root.right)){
            return true;
        }
        return false;
    }
}
