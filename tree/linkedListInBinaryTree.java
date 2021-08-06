class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(root, head, head);
    }
    
    public boolean dfs(TreeNode root, ListNode head, ListNode h) {
        if(head == null) return true;
        if(root == null) return false;
        if(match(root, head)) return true;
        if(dfs(root.left, h, h)) return true;
        if(dfs(root.right, h, h)) return true;
        return  false;
    }
    
    public boolean match(TreeNode root, ListNode head) {
        if(head == null) return true;
        if(root == null) return false;
        if((root.val == head.val)){
            if((match(root.left, head.next) || match(root.right, head.next)))
                return true;
        } 
        return false;
    }
}