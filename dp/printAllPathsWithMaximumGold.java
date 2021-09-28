public void goldmine(int[][]arr){
    int n = arr.length;
    int m = arr[0].length;
    int[][]dp = new int[n][m];

    for(int j=m-1; j>=0; j--){
        for(int i=0; i<n; i++){
            if(j=m-1){
                dp[i][j] = arr[i][j];
            }
            if(i==0){
                dp[i][j] = Math.max(dp[i+1][j+1], dp[i][j+1]) + arr[i][j];
            }
            else if(i==n-1){
                dp[i][j] = Math.max(dp[i-1][j+1], dp[i][j+1]) + arr[i][j];
            }
            else{
                dp[i][j] = Math.max(dp[i+1][j+1], Math.max(dp[i][j+1], dp[i-1][j+1])) + arr[i][j];
            }
        }
    }
    int ans = 0;
    for(int i=0; i<n; i++){
        if(dp[i][0]>ans){
            ans = dp[i][0];
            System.out.println(ans);
            print(dp, ans);
        }
    }
}

public static void print(int[][]dp, int ans){
    ArrayDeque<Pair> que = new ArrayDeque<>();
    for(int i=0; i<n; i++){
        if(dp[i][0]==ans){
            que.add(i+" ", i, 0);
        }
    }
    while(que.size()>0){
        Pair rem = que.remove();
        int i = rem.i;
        int j = rem.j;
        String psf = rem.psf;
        if(j==dp[0].length-1){
            System.out.println(psf);
            continue;
        }
        if(i==0){
            int maxg = Math.max(dp[i][j+1], dp[i+1][j+1]);
            if(dp[i][j+1]==maxg){
                que.add(new Pair(psf+"d2", i, j+1));
            }
            if(dp[i+1][j+1]==maxg){
                que.add(new Pair(psf+"d3", i+1, j+1));
            }
        }else if(i==n-1){
            int maxg = Math.max(dp[i][j+1], dp[i-1][j+1]);
            if(dp[i][j+1]==maxg){
                que.add(new Pair(psf+"d2", i, j+1));
            }
            if(dp[i-1][j+1]==maxg){
                que.add(new Pair(psf+"d1", i-1, j+1));
            }
        }
        else{
            int maxg = Math.max(dp[i+1][j+1],Math.max(dp[i][j+1], dp[i-1][j+1]));
            if(dp[i][j+1]==maxg){
                que.add(new Pair(psf+"d2", i, j+1));
            }
            if(dp[i-1][j+1]==maxg){
                que.add(new Pair(psf+"d1", i-1, j+1));
            }
            if(dp[i+1][j+1]==maxg){
                que.add(new Pair(psf+"d3", i+1, j+1));
            }
        }
    }
}