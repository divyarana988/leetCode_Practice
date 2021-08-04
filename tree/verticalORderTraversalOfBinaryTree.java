class Solution {
    
    public static class pair{
        TreeNode node = null;
        int hl = 0;
        int vl =0;
        pair(TreeNode node, int hl, int vl){
            this.node = node;
            this.hl = hl;
            this.vl = vl;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(root, 0, 0));
        
        HashMap<Integer, ArrayList<pair>> map = new HashMap<>();
        
        int minH =0, maxH =0;
        
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                pair remove = que.removeFirst();
                map.putIfAbsent(remove.hl, new ArrayList<>());
                map.get(remove.hl).add(remove);
                
                minH = Math.min(minH, remove.hl);
                maxH = Math.max(maxH, remove.hl);
                
                if(remove.node.left != null){
                    que.addLast(new pair(remove.node.left, remove.hl-1, remove.vl+1));
                }
                if(remove.node.right != null){
                    que.addLast(new pair(remove.node.right, remove.hl+1, remove.vl+1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=minH; i<=maxH; i++)
        {
            Collections.sort(map.get(i), new Comparator<pair>(){
                public int compare(pair a, pair b)
                {
                    if(a.vl==b.vl) //when y is equal, sort it by value
                        return a.node.val - b.node.val;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }
            });
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<map.get(i).size(); j++)
            {
                list.add(map.get(i).get(j).node.val);
            }
            ans.add(list);
        }
        return ans;
    }
}