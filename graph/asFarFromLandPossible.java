class Solution {
    public class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> que = new ArrayDeque<>();
        int level=-1;
        int res[][] = new int[grid.length][grid[0].length];
        int count=0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c]==1){
                    que.add(new Pair(r,c));
                    res[r][c]= 1;
                }else count++;
            }
        }
        if(count==0) return -1;
        int dir[][] = {{-1, 0}, {0,1}, {1,0}, {0,-1}};
        while(que.size()>0){
            int size = que.size();
            level++;
            while(size-->0){
                
                Pair rem = que.remove();
                for(int d= 0; d<4; d++){
                    int rd = rem.r+dir[d][0];
                     int cd = rem.c+dir[d][1];
                
                     if(rd<0 || cd<0 || rd>=grid.length || cd>=grid[0].length ||  res[rd][cd] == 1 || grid[rd][cd]==1)
                        continue;
                     res[rd][cd] = 1;
                     que.add(new Pair(rd, cd));
                }
            }
            
        }
        return level;
    }
}