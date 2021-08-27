class Solution {
    List<TreeNode> ans = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return convert(0, ans.size()-1);
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ans.add(root);
        inorder(root.right);
    }
    public TreeNode convert(int s, int e){
        if(s>e) return null;
        int mid = s+(e-s)/2;
        TreeNode root = ans.get(mid);
        root.left = convert(s, mid-1);
        root.right = convert(mid+1, e);
        
        return root;
    }
}