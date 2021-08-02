class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return node;
    }
    
    public static TreeNode build(int[]preorder, int psi, int pei, int[]inorder, int isi, int iei){
        if(psi>pei){
            return null;
        }
        int val = preorder[psi];
        int idx = 0;
        while(inorder[idx]!=val){
            idx++;
        }
        int tnel = idx-isi;
        TreeNode node = new TreeNode(val);
        
        node.left = build(preorder, psi+1, psi+tnel, inorder, isi, idx);
        node.right = build(preorder, psi+tnel+1, pei, inorder, idx+1, iei);
        
        return node;
    }
}