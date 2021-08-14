class Solution {
   public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }
    public void helper(List<Integer> list, TreeNode root){
        if(root == null)    return;
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }
}