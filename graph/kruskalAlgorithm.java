

import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
      
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int n = scn.nextInt();
        Edge edges[] = new Edge[n];
        for(int i=0; i<n; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            edges[i] = new Edge(u, v, wt);
        }
        Arrays.sort(edges);
        UnionFind uf = new UnionFind(vtces+1);
        long cost = 0;
        for(Edge e : edges){
            if(uf.union(e.u, e.v))
                cost+=e.wt;
        }
        System.out.print(cost);
  }

  public static class Edge implements Comparable<Edge> {
      int u, v, wt;
      Edge(int u, int v, int wt){
          this.u = u;
          this.v = v;
          this.wt = wt;
      }
      public int compareTo(Edge o){
          return this.wt - o.wt;
      }
  }
  
  public static class UnionFind{
      int[]par;
      int rank[];
      public UnionFind(int vtces){
          par = new int[vtces];
          rank = new int[vtces];
          for(int i=0; i<vtces; i++){
              par[i] = i;
              rank[i] = 1; 
          }
      }
      public boolean union(int v1, int v2){
          int r1 = find(v1), r2 = find(v2);
          if(r1!=r2){
              int rank1 = rank[v1];
              int rank2 = rank[v2];
              if(rank1>rank2)
                par[r2] = r1;
            else if(rank2>rank1)
                par[r1] = r2;
            else{
                par[r2] = r1;
                rank[r1]++;
            }    
            return true;
          }
          return false;
      }
      public int find(int v){
          if(par[v]==v) return v;
          return par[v] = find(par[v]);
      }
  }
  
  
  
  

 
}
