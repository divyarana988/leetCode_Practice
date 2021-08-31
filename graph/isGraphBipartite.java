import java.util.Arrays;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]vis = new int[n];
        Arrays.fill(vis, -1);
        
        for(int i=0; i<n; i++){
            if(vis[i]==-1){
                if(!helper(graph, i, vis))
                    return false;
            }
        }
        return true;
    }
    
    public boolean helper(int[][]graph, int src, int[]vis){
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src, 0));
        
        while(que.size()>0){
            Pair rem = que.remove();
            if(vis[rem.vtx]==-1){
                vis[rem.vtx] = rem.level;
                
                for(int nbr : graph[rem.vtx]){
                    if(vis[nbr]==-1)
                        que.add(new Pair(nbr, rem.level+1));
                    else
                        if(rem.level%2 == vis[nbr]%2)
                            return false;
                }
            }
            else if(vis[rem.vtx]!=1){
                if(rem.level%2 != vis[rem.vtx]%2)
                    return false;
            }
        }
        return true;
    }
    public class Pair{
        int vtx, level;
        Pair(int vtx, int level){
            this.vtx = vtx;
            this.level = level;
        }
    }
}