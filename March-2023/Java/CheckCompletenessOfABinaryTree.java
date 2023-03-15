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
// 958. Check Completeness of a Binary Tree
class Solution {
    public boolean isCompleteTree(TreeNode root) {
    
        Queue<TreeNode> q = new LinkedList<>();
        boolean isnull = false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode t = q.poll();
                //check if node is null
                if(t==null){
                    isnull=true;
                }
                else{
                    // check if previous node is null (all nodes should be far left in a complete binary tree)
                    if(isnull==true){
                        return false;
                    }
                    q.add(t.left);
                    q.add(t.right);
                }
            }
       }
        return true;
    }
    
}
