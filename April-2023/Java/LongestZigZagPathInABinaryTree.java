// 1372. Longest ZigZag Path in a Binary Tree
//Algorithm
// Use a boolean variable to keep track of which direction you currently are in, if left is true, this means you need to go left

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
    int maxPath=0;
    public void dfs(TreeNode root, int steps, boolean left){
        if(root==null) return;
        maxPath=Math.max(maxPath,steps);
        if(left==true){
            dfs(root.left,steps+1,false);
            dfs(root.right,1,true);
        }
        else{
            dfs(root.right,steps+1,true);
            dfs(root.left,1,false);
        }
    }
    
    public int longestZigZag(TreeNode root) {
        dfs(root,0,true);
        dfs(root,0,false);
        return maxPath;
    }
}
