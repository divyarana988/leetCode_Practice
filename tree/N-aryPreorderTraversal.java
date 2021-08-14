class Solution {
   
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public static void helper(Node root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        for(Node child : root.children) {
            helper(child, res);
        }
    }
}