class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head, slowpre = null;
        
        while(fast.next != null && fast.next.next != null){
            slowpre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slowpre != null){
            slowpre.next = null;
        }
        if(slow == null){
            return null;
        }
        TreeNode node = new TreeNode(slow.val);
        
        if(head!=slow){
            node.left = sortedListToBST(head);
        }
        node.right = sortedListToBST(slow.next);
        return node;
    }
 
}