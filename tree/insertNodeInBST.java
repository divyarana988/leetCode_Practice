class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode temp = new TreeNode(val, null, null);
            return temp;
        }
        if(val>root.val){
            root.right = insertIntoBST(root.right, val);
        }
        else if(val<root.val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}