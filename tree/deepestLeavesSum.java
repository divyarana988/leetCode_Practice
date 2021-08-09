class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int sum = 0;
        que.add(root);
        
        while(que.size()>0){
            int size = que.size();
            sum = 0;
            
            for(int i=0; i<size; i++){
                TreeNode curr = que.remove();
                sum+=curr.val;
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
            }
        }
        return sum;
    }
}