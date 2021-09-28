public int sol(String s){
    int n = s.length();
    boolean[][]dp = new boolean[n][n];
    int li = -1, lj = -1;

    for(int d=0; d<n; d++){
        for(int i=0, j=d; j<n; j++,i++){
            if(d==0){
                dp[i][j] = true;
            }
            else if(d==1){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
            else{
                dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
            }
            if(dp[i][j]==true){
                li = i;
                lj = j;
            }
        }
    }
    return li-lj+1;
}