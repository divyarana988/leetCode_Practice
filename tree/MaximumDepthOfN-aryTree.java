class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int ht =0;
        for(Node child: root.children){
            int res = maxDepth(child);
            if(res>ht){
                ht = res;
            }
        }
        return ht+1;
    }
}