class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        
        boolean[] vis = new boolean[n]; 
        vis[0] = true;
        double[] prob = new double[n]; prob[0] = 1f;
        Queue<Integer> q = new LinkedList<>(); 
        q.add(0);
        
        while (q.size()>0 && t-- > 0) {
            for (int size = q.size(); size > 0; size--) {
                int u = q.remove();
                int count = 0;
                for (int v : graph[u]) 
                    if (!vis[v]) count++;
                for (int v : graph[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.add(v);
                        prob[v] = prob[u] / count;
                    }
                }
                if (count > 0) prob[u] = 0; // frog don't stay vertex u, he keeps going to the next vertex
            }
        }
        return prob[target - 1];
    }
}