class Solution {
    
    public class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int x = entrance[0];
        int y = entrance[1];
        boolean [][]vis = new boolean[n][m];
        int [][]dir = {{-1,0},{0,1}, {1,0},{0,-1}};
        
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.addLast(new Pair(x, y));
        int level = 0;
        vis[x][y] = true;
        
        while(que.size()>0){
            int s = que.size();
            
            while(s-->0){
                Pair rem = que.removeFirst();
                int i = rem.x;
                int j = rem.y;
                
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(level!=0)
                        return level;
                }
                
                for(int d=0; d<4; d++){
                    int xd = rem.x+dir[d][0];
                    int yd = rem.y + dir[d][1];
                    
                    if(xd>=0 && xd<n && yd>=0 && yd<m && !vis[xd][yd] && maze[xd][yd]!= '+'){
                    vis[xd][yd]=true;
                        que.addLast(new Pair(xd,yd));
                    }
                }
            }
            level++;
        }
        return -1;
    }
}