class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode node = build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
        return node;
    }
    
     public static TreeNode build(int[]postorder, int psi, int pei, int[]inorder, int isi, int iei){
        if(psi>pei){
            return null;
        }
        int val = postorder[pei];
        int idx = 0;
        while(inorder[idx]!=val){
            idx++;
        }
        int tnel = idx-isi;
        TreeNode node = new TreeNode(val);
        
        node.left = build(postorder, psi, psi+tnel-1, inorder, isi, idx);
        node.right = build(postorder, psi+tnel, pei-1, inorder, idx+1, iei);
        
        return node;
    }    
}