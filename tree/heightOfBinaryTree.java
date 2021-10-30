
class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        // code here 
        if(node==null){
            return 0;
        }
        
        int lht = height(node.left);
        int rht = height(node.right);
        
        return Math.max(lht, rht) + 1;
    }
}
