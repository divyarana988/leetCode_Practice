class Solution {
    boolean found;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        found = false;
        boolean vis[]= new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap();
        
        for(int i=0; i<n; i++){
             graph.put(i, new ArrayList<>());
        }
        
        for(int[]edge: edges){
            List<Integer> list = graph.get(edge[0]);
            list.add(edge[1]);
            graph.put(edge[0], list);
            
            list = graph.get(edge[1]);
            list.add(edge[0]);
            graph.put(edge[1], list);
        }
        dfs(graph, start, end, vis);
        return found;
        
    }
    public void dfs(Map<Integer, List<Integer>> graph, int s, int end, boolean[] vis){
        if(vis[s])
            return;
        vis[s] = true;
        for(int nbr : graph.get(s) ){
            if(nbr==end){
                found=true;
                break;
            }
            if(vis[nbr]==false)
                dfs(graph, nbr, end, vis);
        }
    }
}