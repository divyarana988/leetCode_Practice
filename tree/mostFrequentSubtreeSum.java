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
    public int[] findFrequentTreeSum(TreeNode root) {
  Map<Integer,Integer> map = new HashMap();
  helper(map, root);  
  int max = 0;
  for (int key : map.keySet()) {
    max = Math.max(max, map.get(key));
  } 
  
  List<Integer> res = new ArrayList();
  for(int key: map.keySet()){
    if(map.get(key) == max) res.add(key);
  }     
  
  int[] result = new int[res.size()];
  for(int i = 0; i < res.size(); i++){
    result[i] = res.get(i);  
  }
  return result; 
}

int helper(Map<Integer,Integer> map, TreeNode root){
  if(root == null) return 0;
  int left = helper(map, root.left);
  int right = helper(map, root.right);
  int sum = left + right + root.val;
  int count = map.getOrDefault(sum, 0);
  map.put(sum, count + 1);
  return sum;
}
}