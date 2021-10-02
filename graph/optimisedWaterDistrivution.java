 public static class Pair implements Comparable <Pair> {
     int vtx, wt;
     Pair(int vtx, int wt){
         this.vtx = vtx;
         this.wt = wt;
     }
     public int compareTo(Pair o){
         return this.wt - o.wt;
     }
 }    


  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
    }
    for(int i=0; i<pipes.length; i++){
        int u = pipes[i][0];
        int v = pipes[i][1];
        int wt = pipes[i][2];
        
        graph.get(u).add(new Pair(v, wt));
        graph.get(v).add(new Pair(u, wt));
    }
    
    for(int i=1; i<=n; i++){
        graph.get(i).add(new Pair(0, wells[i-1]));
        graph.get(0).add(new Pair(i, wells[i-1]));
    }
    int ans = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0,0));
    boolean[]vis = new boolean[n+1];
    
    while(pq.size()>0){
        Pair rem = pq.remove();
        if(vis[rem.vtx]==true){
            continue;
        }
        vis[rem.vtx] = true;
        ans+=rem.wt;
        
        ArrayList<Pair> nbrs = graph.get(rem.vtx);
        
        for(Pair nbr: nbrs){
            if(vis[nbr.vtx]==false){
                pq.add(nbr);
            }
        }
    }
    return ans;
  }