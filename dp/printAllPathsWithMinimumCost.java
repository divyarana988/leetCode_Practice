public static void sol(int[][]cost){
    int n = cost.length;
    int m = cost[0].length;
    int[][] dp = new int[n][m];

    for(int i=n-1; i>=0; i--){
        for(int j=m-1; j>=0; j--){
            if(i==dp.length-1 && j==dp[0].length-1){
                dp[i][j] = cost[i][j];
            }
            else if(i==n-1){
                dp[i][j] = dp[i][j+1] + cost[i][j];
            }
            else if(j==m-1){
                dp[i][j] = dp[i+1][j] + cost[i][j]; 
            }
            else{
                dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) + cost[i][j];
            }
        }
    }
    System.out.println(dp[0][0]);
    print(dp);
}

public static void print(int[][] dp){
    ArrayDeque<Pair> que = new ArrayDeque<>();
    que.add(new Pair("", 0, 0));

    while(que.size()>0){
        Pair rem = que.remove();
        String psf = rem.psf;
        int i = rem.i;
        int j = rem.j;

        if(i==dp.length-1 && j==dp[0].length-1){
            System.out.println(psf);
            continue;
        }
        if(i==dp.length-1){
            que.add(new Pair(psf+"H", i, j+1));
        }
        else if(j==dp[0].length-1){
            que.add(new Pair(psf+"V", i+1, j));
        }
        else{
            int minc = Math.min(dp[i][j+1], dp[i+1][j]);
            if(dp[i+1][j]==minc){
                que.add(new Pair(psf+"V", i+1, j));
            }
            if(dp[i][j+1]==minc){
                que.add(new Pair(psf+"H", i, j+1));
            }
        }
    }
}
