
import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nvtces = scn.nextInt();
        int nedges = scn.nextInt();
        int edges[][] = new int[nedges][2];
        for(int i=0; i<nedges; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            edges[i][0] = u;
            edges[i][1] = v;
        }
        System.out.println(Ap(edges, nvtces));
  }
    
    static int dis[];
    static int low[];
    static int par[];
    static boolean vis[];
    static boolean ap[];
    static int time;
    static int count;
    
    public static int Ap(int[][]edges, int nvtces){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<nvtces+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dis = new int[nvtces+1];
        low = new int[nvtces+1];
        par = new int[nvtces+1];
        vis = new boolean[nvtces+1];
        ap = new boolean[nvtces+1];
        time = 1;
        count = 0;
        
        dfs(1, graph);
        int res = 0;
        for(int i=1; i<=nvtces; i++){
            if(ap[i])
                res++;
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
                else if(low[v]>=dis[u])
                    ap[u] = true;
                low[u] = Math.min(low[u], low[v]);    
            }    
        }
        
    }  
}