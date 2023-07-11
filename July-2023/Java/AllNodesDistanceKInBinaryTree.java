// 863. All Nodes Distance K in Binary Tree
// First set the parent of each node, so we can traverse backwards and find the depth
// then apply a simple bfs
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public void addParent(TreeNode root){
        if(root==null) return;
        if(root.left!=null)
            map.put(root.left, root);
        addParent(root.left);
        if(root.right!=null)
            map.put(root.right,root);
        addParent(root.right);
    }         
        
    public void bfs(TreeNode target, int k, List<Integer> result){
        Queue<TreeNode> queue = new LinkedList<>();
        
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        queue.add(target);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            if(k==0) break;
            while(size-->0){
                TreeNode temp = queue.poll();
                if(temp.left!=null && !visited.contains(temp.left.val)){
                    queue.add(temp.left);
                    visited.add(temp.left.val);
                                
                 }
                
                if(temp.right!=null && !visited.contains(temp.right.val)){
                    queue.add(temp.right);
                    visited.add(temp.right.val);
                }
                TreeNode t = map.get(temp);
                if(map.containsKey(temp) && !visited.contains(t.val)){
                    
                    
                    queue.add(t);
                    visited.add(t.val);
                 }
                
            }
            k--;
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
        }
    }    
        
        
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new LinkedList<>();
        addParent(root);
        bfs(target,k,result);
        return result;
    }
}
