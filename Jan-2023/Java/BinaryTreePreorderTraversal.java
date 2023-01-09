
//144. Binary Tree Preorder Traversal

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
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ls = new LinkedList<>();
        dfs(root,ls);
        return ls;
    }
    
    public void dfs(TreeNode root, List<Integer> ls){
        if(root==null) return; //nothing to add return
        //Preorder, root, left, right
        ls.add(root.val); //root
        dfs(root.left,ls); //left branch 
        dfs(root.right,ls); //right branch
    }
} 
