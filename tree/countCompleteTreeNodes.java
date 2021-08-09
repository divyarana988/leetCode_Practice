class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftD = 1;
        TreeNode leftN = root.left;
        while(leftN!=null){
            leftN = leftN.left;
            leftD+=1;
        }
        
        int rightD = 1;
        TreeNode rightN = root.right;
        while(rightN!=null){
            rightN = rightN.right;
            rightD+=1;
        }
        
        if(leftD == rightD){
            return (1 << leftD)-1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}