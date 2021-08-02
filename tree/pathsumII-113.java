class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    
    public static void helper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                List<Integer> temp = new ArrayList<>();
                for(int val : path)
                    temp.add(val);
                temp.add(root.val);
                ans.add(temp);
            }
            return;
        }
        path.add(root.val);
        helper(root.left, targetSum-root.val, path, ans);
        helper(root.right, targetSum-root.val, path, ans);
        path.remove(path.size()-1);
        
    }
}