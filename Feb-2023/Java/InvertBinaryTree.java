// 226. Invert Binary Tree
// Swap left and right nodes
// recursively call left and right nodes until null

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
    public TreeNode invertTree(TreeNode root) {
        return pre(root);
    }
    
    public TreeNode pre(TreeNode root){
          if(root==null) return root;
         
          TreeNode left=pre(root.left);
          TreeNode right=pre(root.right);
        
          root.right=left;
        root.left=right;
        
        
        return root;
        }
}
  
