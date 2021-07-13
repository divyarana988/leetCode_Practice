class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        path.add(0);
        sol(graph, 0, res, path);
        
        return res;
        
    }
    
    public void sol(int [][] graph, int vtx, List<List<Integer>> res, List<Integer> path){
        if(vtx == graph.length-1){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int nextVtx : graph[vtx]){
            path.add(nextVtx);
            sol(graph, nextVtx, res, path);
            path.remove(path.size()-1);
        }
        
    }
    
}