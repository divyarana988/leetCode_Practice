class Solution {
    public class Pair implements Comparable<Pair>{
        int r, c, mwt;
        Pair(int r, int c, int mwt){
            this.r = r;
            this.c = c;
            this.mwt = mwt;
        }
        
        public int compareTo(Pair o){
            return this.mwt - o.mwt;
        }
    }
    int[][]dir = {{-1, 0}, {0, 1}, {1,0}, {0,-1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(true){
            Pair rem = pq.remove();
            if(rem.r == grid.length-1 && rem.c == grid[0].length-1){
                return rem.mwt;
            }
            if(vis[rem.r][rem.c] == true){
                continue;
            }
            vis[rem.r][rem.c] = true;
            for(int d=0 ;d<4; d++){
                int rd = rem.r+dir[d][0];
                int cd = rem.c+dir[d][1];
                
                if(rd<0 || cd<0 || rd>=grid.length || cd>=grid[0].length || vis[rd][cd]==true)
                    continue;
                pq.add(new Pair(rd, cd, Math.max(rem.mwt, grid[rd][cd])));
            }
        }
    }
}