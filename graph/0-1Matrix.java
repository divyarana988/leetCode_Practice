class Solution {
    public class Pair{
        int r, c, level;
        Pair(int r, int c, int level){
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> que = new ArrayDeque<>();
        int res[][] = new int[mat.length][mat[0].length];
        
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                if(mat[r][c] ==0){
                    que.add(new Pair(r,c,0));
                }
            }
        }
        
        int dir[][] = {{-1, 0}, {0,1}, {1,0}, {0,-1}};
        
        while(que.size()>0){
            Pair rem = que.remove();
            res[rem.r][rem.c] = rem.level;
            
            for(int d=0; d<4; d++){
                int rd = rem.r + dir[d][0];
                int cd = rem.c + dir[d][1];
                
                if(rd<0 || cd<0 || rd>=mat.length || cd>=mat[0].length || mat[rd][cd]!=1)
                    continue;
                mat[rd][cd] = 0;
                que.add(new Pair(rd, cd, rem.level+1));
            }
        }
        return res;
    }
}