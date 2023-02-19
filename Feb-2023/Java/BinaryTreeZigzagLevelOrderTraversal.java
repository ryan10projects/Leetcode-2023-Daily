// 103. Binary Tree Zigzag Level Order Traversal

// Keep a toggle boolean value, to reverse the elements while transversing for making a zigzag pattern

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root==null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>(); 

        List<List<Integer>> res = new ArrayList<>();

        q.add(root);

        boolean reversecheck=false;

        while(!q.isEmpty()){           

            int size = q.size();

            List<Integer> ls = new LinkedList<>();

            while(size>0){

                size--;

                root = q.poll();

                ls.add(root.val);

                if(root.left!=null) q.add(root.left);

                if(root.right!=null) q.add(root.right);                             }

            if(reversecheck) Collections.reverse(ls);

            res.add(ls);

            reversecheck = !reversecheck;

            }

        return res;

    }

}
