class Solution {
    class UnionFind{
        int par[], rank[];
        
        UnionFind(int vtces){
            par = new int[vtces+1];
            rank = new int[vtces+1];
            for(int i=1; i<vtces; i++)
                par[i] = i;
            
        }
        
        void union(int v1, int v2){
            int r1 = find(v1);
            int r2 = find(v2);
            if(r1!=r2){
                int rank1 = rank[v1];
                int rank2 = rank[v2];
                
                if(rank1>rank2){
                    par[r2] = r1;
                }else if(rank2>rank1){
                    par[r1] = r2;
                }else{
                    par[r2]=r1;
                    rank[r1]++;
                }
            }
        }
        int find(int v){
            if(par[v]==v)
                return v;
            return par[v]=find(par[v]);
        }
        boolean connected(int v1, int v2){
            return find(v1)==find(v2);
        }
            
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int indeg[] = new int[n+1];
        Arrays.fill(indeg, -1);
        int bl1=-1, bl2=-1;
        
        for(int i=0; i<edges.length; i++){
            int edge[]= edges[i];
            int u = edge[0];
            int v = edge[1];
            if(indeg[v]==-1)
                indeg[v] = i;
            else{
                bl1 = i;
                bl2 = indeg[v];
            }
        }
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<edges.length; i++){
            int edge[] = edges[i];
            int u = edge[0];
            int v = edge[1];
            if(bl1==-1){
                if(uf.connected(u,v))
                    return edge;
                else 
                    uf.union(u,v);
            }else{
                if(i!=bl1){
                    if(uf.connected(u,v))
                        return edges[bl2];
                    else
                        uf.union(u,v);
                }
            }
        }
        return edges[bl1];
    }
}