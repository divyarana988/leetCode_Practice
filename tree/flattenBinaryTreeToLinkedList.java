class Solution {
    public void flatten(TreeNode root) {
        falt(root);
    }
    public TreeNode falt(TreeNode root){
        if(root == null){
            return null;
        }        
        TreeNode rightn = root.right;
        TreeNode leftT = falt(root.left);
        TreeNode rightT = falt(root.right);
        
        if(root.left == null && root.right == null){
            return root;
        }
        else if(root.left == null){
            return rightT;
        }
        else if(root.right == null){
            root.right = root.left;
            root.left = null;
            return leftT;
        }
        else
        {
            leftT.right = rightn;
            root.right = root.left;
            root.left = null;
            return rightT;
        }
    }
}