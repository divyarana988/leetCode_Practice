class Solution
{
    static class Pair implements Comparable<Pair>{
        int vtx, wsf;
        Pair(int vtx, int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] vis = new int[V];
        Arrays.fill(vis, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));
        
        while(pq.size()>0){
            Pair rem = pq.remove();
            if(vis[rem.vtx]!=-1){
                continue;
            }
            vis[rem.vtx] = rem.wsf;
            ArrayList<ArrayList<Integer>> edges = adj.get(rem.vtx);
            for(ArrayList<Integer> edge:  edges){
                int nbr = edge.get(0);
                int wt = edge.get(1);
                if(vis[nbr]==-1){
                    pq.add(new Pair(nbr, rem.wsf+wt));
                }
            }
        }
        return vis;
    }
}