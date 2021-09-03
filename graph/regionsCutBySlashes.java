class Solution {
    class UnionFind{
        int par[], rank[], count;
        
        UnionFind(int n){
            count=1;
            par = new int[(n+1)*(n+1)];
            rank = new int[(n+1)*(n+1)];
            for(int i=0; i<(n+1)*(n+1); i++)
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
                }
                else if(rank2>rank1){
                    par[r1] = r2;
                }else{
                    par[r2] = r1;
                    rank[r1]++;
                }
            }else
                count++;
        }
        int find(int v){
            if(par[v]==v)
                return v;
            return par[v] = find(par[v]);
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n);
        
        for(int r=0; r<n+1; r++){
            for(int c=0; c<n+1; c++){
                if(r==0 && c==0)
                    continue;
                if(r==0 || c==0 || r==n || c==n){
                    int point = r*(n+1) + c;
                    uf.union(0, point);
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            String rowIp = grid[i];
            for(int j=0; j<rowIp.length(); j++){
                char ch = rowIp.charAt(j);
                if(ch=='/'){
                    int p1 = i*(n+1) + j+1;
                    int p2 = (i+1)*(n+1) + j;
                    uf.union(p1, p2);
                }else if(ch=='\\'){
                    int p1 = i*(n+1) + j;
                    int p2 = (i+1)*(n+1) + j+1;
                    uf.union(p1, p2);
                }
            }
        }
        return uf.count;
    }
}