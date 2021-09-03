/*package whatever //do not write package name here */
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.*;

class GFG {
    
    public static class Edge{
        int src, nbr, wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static class Pair implements Comparable<Pair>{
        int vtx,wt;
        Pair(int vtx, int wt){
            this.vtx  = vtx;
            this.wt = wt;
        }
        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }
    
	public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        ArrayList<Edge>[]graph = new ArrayList[vtces+1];
        for(int i=0; i<=vtces; i++){
            graph[i] = new ArrayList<>();
        }
        for(int r=1; r<=vtces; r++){
            for(int c=1; c<=vtces; c++){
                int v1 = scn.nextInt();
                if(v1>0){
                    graph[r].add(new Edge(r,c,v1));
                }
            }
        }
        System.out.println(solve(graph));
	}
	public static int solve(ArrayList<Edge>[]graph){
	    int nvtce = graph.length;
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    pq.add(new Pair(1, 0));
	    boolean[] vis = new boolean[nvtce];
	    int ans = 0;
	    
	    while(pq.size()>0){
	        Pair rem = pq.remove();
	        if(vis[rem.vtx]==true)
	            continue;
	        vis[rem.vtx] = true;
	        ans+=rem.wt;
	        
	        for(Edge e: graph[rem.vtx]){
	            if(vis[e.nbr]==false){
	                pq.add(new Pair(e.nbr, e.wt));
	            }
	        }
	    }
	    return ans;
	}
}