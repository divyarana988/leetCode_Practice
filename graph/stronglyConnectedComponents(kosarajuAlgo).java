class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        Stack<Integer> st = new Stack<>();
        boolean [] vis = new boolean[V];
        for(int vtx=0; vtx<V; vtx++){
            if(vis[vtx]==false)
                dfs1(graph, vtx, vis, st);
        }
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        for(int vtx =0; vtx<V; vtx++){
            revGraph.add(new ArrayList<Integer>());
        }
        for(int vtx=0; vtx<V; vtx++){
            ArrayList<Integer> nbrs = graph.get(vtx);
            for(int nbr : nbrs)
                revGraph.get(nbr).add(vtx);
        }
        int count =0;
        vis = new boolean[V];
        while(st.size()>0){
            int vtx = st.pop();
            if(vis[vtx]==false){
                count++;
                dfs2(revGraph, vtx, vis);
            }
        }
        return count;
    }
    public void dfs1(ArrayList<ArrayList<Integer>> graph, int src, boolean[]vis, Stack<Integer> st){
        vis[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr: nbrs){
            if(vis[nbr]==false)
                dfs1(graph, nbr, vis, st);
        }
        st.push(src);
    }
    public void dfs2(ArrayList<ArrayList<Integer>> graph, int src, boolean[]vis){
        vis[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr: nbrs){
            if(vis[nbr]==false)
                dfs2(graph, nbr, vis);
        }
    }
}