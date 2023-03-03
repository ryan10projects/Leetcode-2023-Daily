// 652. Find Duplicate Subtrees
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
    public String checkstring(TreeNode root,HashMap<String,Integer> map, List<TreeNode> res){
        String s = "";
        // Null check added to match schema
        if(root==null) return "NULL";
        // Starting from the root, keep track of all values from a particular node
        s = String.valueOf(root.val)+","+checkstring(root.left,map,res)+","+checkstring(root.right,map,res);
       // Only add the root if duplicate is found once
        if(map.containsKey(s) && map.get(s)==1){
            res.add(root);
         }
        // Add the count to make sure to not add it if it's a duplicate in the next recursion call in the above code
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
     }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        if(root==null) return res;
        checkstring(root,map,res);
        return res;
    }
}
