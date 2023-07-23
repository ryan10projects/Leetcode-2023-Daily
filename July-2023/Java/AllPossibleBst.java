
// go through all the odd numbers in N, only then you will find a bst
// then loop though the left side of i(root) and right side to get all possible combinations of bst
// add the result and return
class Solution {
    public List<TreeNode> solve(int n) {
        List<TreeNode> result = new LinkedList<>();

        if (n == 1) {
            TreeNode node = new TreeNode(0);
            result.add(node);
            return result;
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = solve(i);
            List<TreeNode> right = solve(n - i-1);
            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = nodeL;
                    root.right = nodeR;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
}
