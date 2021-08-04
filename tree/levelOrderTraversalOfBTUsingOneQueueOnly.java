class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) {
            que.add(root);
        }
        
        while (que.size()>0) {
            int len = que.size();
            List<Integer> res = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                
                TreeNode temp = que.remove();
                
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
                res.add(temp.val);
            }
            ans.add(res);
        }
        
        return ans;
    }
}