class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null){
        return null;
    }
    if(key < root.val){
        root.left = deleteNode(root.left, key);
    }else if(key > root.val){
        root.right = deleteNode(root.right, key);
    }else{
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }
        
        
        root.val = findMin(root.right);
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}

private int findMin(TreeNode node){
    int valued = node.val;
    while(node.left != null){
        valued = node.left.val;
        node = node.left;
    }
    return valued;
}
    
}