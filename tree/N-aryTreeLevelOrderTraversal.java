class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(que.size()>0){
            List<Integer> temp = new LinkedList<>();
            int len = que.size();
            for(int i=0; i<len; i++){
                Node curr = que.remove();
                temp.add(curr.val);
                for(Node child: curr.children){
                    que.add(child);
                }
            }
            res.add(temp);
        }
        return res;
    }
}