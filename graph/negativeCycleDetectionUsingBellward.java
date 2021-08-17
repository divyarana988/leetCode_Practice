class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        
        for(int i=0; i<n-1; i++){
            for(int idx=0; idx<edges.length; idx++){
                
                int edge[] = edges[idx];
                
                int u = edge[0], v= edge[1], w= edge[2];
                
                if(ans[u]!=Integer.MAX_VALUE && ans[u]+w < ans[v])
                    ans[v] = ans[u] + w;
                 
            }
        }
        
        for(int idx=0; idx<edges.length; idx++){
            int edge[] = edges[idx];
                
                int u = edge[0], v= edge[1], w= edge[2];
                
                if(ans[u]!=Integer.MAX_VALUE && ans[u]+w < ans[v])
                    return 1;
                 
        }
        return 0;
    }
}