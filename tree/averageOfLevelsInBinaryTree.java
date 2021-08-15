class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while(que.size()>0){
            int n = que.size();
            Double sum = 0.0;
            for(int i=0; i<n; i++){
                TreeNode curr = que.remove();
                sum += curr.val;
                if(curr.left!=null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            result.add(sum/n);
        }
        return result;
    }
}