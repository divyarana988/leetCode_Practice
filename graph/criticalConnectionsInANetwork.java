class Solution {
    int dis[];
    int low[];
    int par[];
    boolean vis[];
    int time;
    int count;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) 
            graph.add(new ArrayList<>());
        
        for(List<Integer> oneConnection :connections) {
            int u = oneConnection.get(0);
            int v = oneConnection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<List<Integer>> results = new ArrayList<>();
        dis = new int[n+1];
        low = new int[n+1];
        par = new int[n+1];
        vis = new boolean[n+1];
        time = 1;
        count = 0;
        
        dfs(graph, 0, results);
        return results;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, int u, List<List<Integer>> result ){
        
        dis[u] = time;
        low[u] = time;
        vis[u] = true;
        time++;
        
        for(Integer v: graph.get(u)){
            if(par[u] == v){
                continue;
            }
            else if(vis[v] == true){
                low[u] = Math.min(low[u], dis[v]);
            }else{
                par[v] = u;
                dfs(graph, v, result);
                if(low[v]>dis[u]){
                    result.add(Arrays.asList(u, v));
                }
                low[u] = Math.min(low[u], low[v]);
            }
        }
        
    }
    
}