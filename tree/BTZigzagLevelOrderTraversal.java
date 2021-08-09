/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean reverse = false;
    
    while (!queue.isEmpty()) {
        int size = queue.size();

        /* use linkedlist to control time complexity of addFirst to O(1) */
        LinkedList<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            TreeNode curNode = queue.poll();
            if (reverse) {
                tempList.addFirst(curNode.val);
            }
            else {
                tempList.add(curNode.val);
            }
            
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        result.add(tempList);
        reverse = !reverse;
    }
    return result;
}
}