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
 // 106. Construct Binary Tree from Inorder and Postorder Traversal
// Algorithm 
// we fetch the post order end first and make it the root. Then traverse the inorder array till the root is found, if found divide it into two halves, left half for root.left and right half for root.right and repeat the process
class Solution {
    public TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart>inEnd) return null;
        if(postStart>postEnd) return null;
        // end of postorder will always be the root
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i=0;
        for(; i<inorder.length; i++){
            if(inorder[i]==root.val) break;
        }
        // fetch left and right subarray
        int left = i-inStart;
        int right = inEnd-i;
        root.left = solve(inorder,postorder,inStart,i-1,postStart,postStart+left-1);
        root.right = solve(inorder,postorder, i+1, inEnd, postEnd-right, postEnd-1);
        return root;
     }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder,postorder,0,inorder.length-1,0, inorder.length-1);
    }
}
