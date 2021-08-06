class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level=0;
        
        while(que.size()>0){
            int prevO = Integer.MAX_VALUE;
            int prevE = Integer.MIN_VALUE;
            
            for(int i = que.size(); i>0; i--){
                TreeNode curr = que.remove();
                
                if(curr.val%2 == level%2)
                    return false;
                if(level%2==1){
                    if(prevO<=curr.val)
                        return false;
                    prevO = curr.val;
                }else{
                    if(prevE>=curr.val)
                        return false;
                    prevE = curr.val;
                }
                if(curr.left != null)
                    que.add(curr.left);
                if(curr.right != null)
                    que.add(curr.right);
            }
            ++level;
        }
        return true;
    }
}