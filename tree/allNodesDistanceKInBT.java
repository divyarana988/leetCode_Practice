
class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return new ArrayList<>();
        find(root,k, target);
        return ans;
    }
    public int find(TreeNode node,int k, TreeNode tar){
        if(node==null) return 0;
        if(node.val==tar.val){
            kLevelsDown(node, k ,null);
            return 1;
        }
        int left = find(node.left, k, tar);
        if(left!=0){
            kLevelsDown(node, k-left, node.left);
            return left+1;
        }
        int right = find(node.right, k, tar);
        if(right!=0){
            kLevelsDown(node, k-right, node.right);
            return right+1;
        }
        return 0;
    }
    
    public void kLevelsDown(TreeNode node, int k, TreeNode block){
        if(node==null || k<0 || node==block) return ;
        if(k==0){
            ans.add(node.val);
        }
        kLevelsDown(node.left, k-1, block);
        kLevelsDown(node.right, k-1, block);
        
    }
    
   
}