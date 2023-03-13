// 101. Symmetric Tree
// just make sure the recrusion for left and right comparison both return true using &&
class Solution {
public:
    bool isTrue(TreeNode* left, TreeNode* right){
        if(left == nullptr && right == nullptr) return true;
        if(left == nullptr || right == nullptr) return false;
        if(left->val != right->val) return false;
        return isTrue(left->left, right->right) && isTrue(left->right, right->left);
    }
    
    bool isSymmetric(TreeNode* root) {
        // for single node
        if(root == nullptr) return true;
        // if anyone is null, that means its not a mirror
        if(root->left == nullptr && root->right == nullptr) return true;
        if(root->left == nullptr || root->right == nullptr) return false;
        return isTrue(root->left, root->right);
    }
};
