class Solution {
    public int maximalSquare(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        int omax = 0;
        
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                
                if(i==n-1 || j==m-1 || a[i][j]=='0'){
                    dp[i][j] = a[i][j] - '0';
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                   
                }
                 omax = Math.max(omax, dp[i][j]);
            }
        }
        return omax*omax;
    }
}