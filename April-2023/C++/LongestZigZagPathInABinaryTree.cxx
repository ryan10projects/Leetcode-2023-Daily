// 1372. Longest ZigZag Path in a Binary Tree
//Algorithm
// Use a boolean variable to keep track of which direction you currently are in, if left is true, this means you need to go left
class Solution {
public:
    int maxPath = 0;

    void dfs(TreeNode* root, int steps, bool left) {
        if (root == nullptr) return;
        maxPath = max(maxPath, steps);
        if (left) {
            dfs(root->left, steps + 1, false);
            dfs(root->right, 1, true);
        }
        else {
            dfs(root->right, steps + 1, true);
            dfs(root->left, 1, false);
        }
    }

    int longestZigZag(TreeNode* root) {
        dfs(root, 0, true);
        dfs(root, 0, false);
        return maxPath;
    }
};
