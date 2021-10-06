class Complete{
    
    // Function for finding maximum and value pair
    static int[] dis;
    static int[] low;
    static int[] par;
    static boolean[] vis;
    static boolean[] ap;
    static int time;
    static int count;
    
    public static int doctorStrange (int n, int k, int g[][]) {
        //Complete the function
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ;i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<k; i++){
            int u = g[i][0];
            int v = g[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dis = new int[n+1];
        low = new int[n+1];
        par = new int[n+1];
        vis = new boolean[n+1];
        ap = new boolean[n+1];
        time = 1;
        count = 0;
        
        dfs(1, graph);
        int res = 0;
        
        for(int i=1; i<=n; i++){
            if(ap[i]){
                res++;
            }
        }
        return res;
    }
    
    public static void dfs(int u, ArrayList<ArrayList<Integer>> graph){
        dis[u] = time;
        low[u] = time;
        vis[u] = true;
        time++;
        
        for(Integer v : graph.get(u)){
            if(par[u]==v)
                continue;
            else if(vis[v]==true)
                low[u] = Math.min(low[u], dis[v]);
            else{
                par[v] = u;
                dfs(v, graph);
                if(par[u]==0){
                    count++;
                    if(count>=2){
                        ap[u] = true;
                    }
                }
                else 
                if(low[v]>=dis[u])
                    ap[u] = true;
                low[u] = Math.min(low[u], low[v]);    
            }    
        }
        
    }
}