class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return areMirror(root.left, root.right);   
    }
    
    public static boolean areMirror(TreeNode p, TreeNode q){
        if(p==null || q==null){
            return p==q;
        }
        if(p.val == q.val && areMirror(p.left, q.right) && areMirror(p.right, q.left)){
            return true;
        }
        return false;
    }
}