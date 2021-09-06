class Solution {
    class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int dir[][] = {{-1, 0},{0, 1}, {1, 0}, {0,-1}};
    public int shortestBridge(int[][] grid) {
        LinkedList<Pair> que = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        
        for(int r=0; r<grid.length && !flag; r++){
            for(int c=0; c<grid[0].length && !flag; c++){
                if(grid[r][c]==1){
                    dfs(r, c, grid, que, vis);
                    flag = true;
                }
            }
        }
        int level = 0;
        while(que.size()>0){
            int n = que.size();
            while(n-->0){
                Pair rem = que.removeFirst();
                for(int d=0 ;d<4; d++){
                    int rd = rem.r + dir[d][0];
                    int cd = rem.c + dir[d][1];
                    
                    if(rd<0 || cd<0 || rd>=grid.length || cd>=grid[0].length || vis[rd][cd]==true)
                        continue;
                    if(grid[rd][cd]==1)
                        return level;
                    que.addLast(new Pair(rd, cd));
                    vis[rd][cd] = true;
                }
            }
            level++;
        }
        return -1;
    }
    
    public void dfs(int r, int c, int[][]grid, LinkedList<Pair> que, boolean vis[][]){
        vis[r][c] = true;
        que.addLast(new Pair(r, c));
        
        for(int d=0 ;d<4; d++){
                    int rd = r + dir[d][0];
                    int cd = c + dir[d][1];
                    
                    if(rd<0 || cd<0 || rd>=grid.length || cd>=grid[0].length || vis[rd][cd]==true || grid[rd][cd]==0)
                        continue;
                dfs(rd, cd,grid, que, vis);
                }
    }
}