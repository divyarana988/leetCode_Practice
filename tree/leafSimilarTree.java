class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        helper(root1, s1);
        helper(root2, s2);
        
        return s1.toString().equals(s2.toString());
    }
    
    public static void helper(TreeNode root, StringBuilder s){
        if(root == null) return ;
        if(root.left == null && root.right == null) s.append(root.val+"-");
        helper(root.left, s);
        helper(root.right, s);
    }
}


