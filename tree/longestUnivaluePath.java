class Solution {
    int len;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        len = 0;
        get(root, root.val);
        return len;
    }
    
    public int get(TreeNode node, int val){
        if(node == null){
            return 0;
        }
        int left = get(node.left, node.val);
        int right = get(node.right, node.val);
        
        len =Math.max(len, left+right);
        
        if(val == node.val){
            return Math.max(left, right)+1;
        }
        return 0;
    }
}