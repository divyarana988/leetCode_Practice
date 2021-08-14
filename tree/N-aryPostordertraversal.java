class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public static void helper(Node root, List<Integer> res){
        if(root == null) return;
        
        for(Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }

}