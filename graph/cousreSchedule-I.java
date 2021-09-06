class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int v=0; v<numCourses; v++){
            graph.add(new ArrayList<>());
        }
        int degree[] = new int[numCourses];
        
        for(int edge[] : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        LinkedList<Integer> que = new LinkedList<>();
        for(int v=0; v<numCourses; v++){
            if(degree[v]==0)
                que.addLast(v);
        }
        int count =0;
        int[] ans = new int[numCourses];
        boolean[]vis = new boolean[numCourses];
        
        while(que.size()>0){
            Integer rem = que.removeFirst();
            vis[rem] = true;
            ans[count] = rem;
            count++;
            
            ArrayList<Integer> nbrs = graph.get(rem);
            for(int nbr: nbrs){
                degree[nbr]--;
                if(vis[nbr]==false && degree[nbr]==0)
                    que.addLast(nbr);
            }
            
        }
        if(count==numCourses)
                return true;
            else return false;
    }
}