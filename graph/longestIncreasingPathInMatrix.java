class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int [][] dp = new int[mat.length][mat[0].length];
        int maxi= 0;
        for(int i=0 ;i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                maxi = Math.max(maxi, dfs(i,j,mat,dp));
            }
        }
        return maxi;
    }
    
    public int dfs(int i, int j, int[][] mat, int[][] dp){
        
       if(dp[i][j]!=0) return dp[i][j];
        
       int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int res = 1;
        
        for(int d=0; d<4; d++){
            int ni = i+dir[d][0];
            int nj = j+dir[d][1];
            
            if(ni>=0 && nj>=0 && ni<mat.length && nj<mat[0].length && mat[ni][nj]>mat[i][j])
                res = Math.max(res, 1 + dfs(ni, nj, mat, dp));
            
        }
        dp[i][j] = res;
        return dp[i][j];
    }
}