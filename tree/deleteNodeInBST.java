class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(key<root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else{
            if(root.left!=null && root.right!=null){
                int maxv = findMax(root.left);
                root.val = maxv;
                root.left= deleteNode(root.left, maxv);
                return root;
            }
            else if(root.left!=null){
                TreeNode temp = root.left;
                root.left = null;
                return temp;
            }
            else if(root.right!=null){
                TreeNode temp = root.right;
                root.right = null;
                return temp;
            }
            else 
                return null;
        }
}

    private int findMax(TreeNode node){
       if(node.right!=null)
           return findMax(node.right);
        else 
            return node.val;
    }
    
}