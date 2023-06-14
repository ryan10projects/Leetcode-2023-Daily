// 530. Minimum Absolute Difference in BST
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

    

    int min = Integer.MAX_VALUE;

    

    TreeNode prev = null;

    

    public int getMinimumDifference(TreeNode root) {

      

        solve(root);

        

        return min;

    }

    

    public void solve(TreeNode root){

        

        if(root==null) return;

        

        solve(root.left);

        

        if(prev!=null){

            

        int diff = Math.abs(prev.val-root.val);

        

        min = Math.min(diff,min);

        }

        

        prev=root;

        

        solve(root.right);

        

     

    }

}
