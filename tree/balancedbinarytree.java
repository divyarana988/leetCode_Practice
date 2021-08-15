class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}