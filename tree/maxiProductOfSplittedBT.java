class Solution {
    long res = 0;
    long total = 0;
    long sub;
    public int maxProduct(TreeNode root) {
        total = s(root);
        s(root);
        return (int)(res%(int)(1e9 + 7));
    }
    
    public long s(TreeNode root){
        if(root == null){
            return 0;
        }
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub*(total-sub));
        return sub;
    }
}