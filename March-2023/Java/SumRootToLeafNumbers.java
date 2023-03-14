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
// 129. Sum Root to Leaf Numbers
class Solution {
     int solve(TreeNode root, int curr){
        if(root==null) return 0;
        // node 1
        // node 2
        // 1*10=10
        // 10+2(value of node 2)
        //12
        curr = (curr*10)+root.val;
        if(root.left==null && root.right==null) return curr;
        // get ths curr for left node and right node
        int left_node = solve(root.left,curr);
        int right_node = solve(root.right,curr);
        // adds all the left and right node recursively
        return left_node+right_node;
     }    
    public int sumNumbers(TreeNode root) {
        return solve(root,0);        
    }
 
        
    
}
