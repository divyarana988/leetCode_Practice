 
 
 public static void sol(int[]val, int[]wt, int cap){
        int n = val.length;
        int[][]dp = new int[n+1][cap+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                else if(j==0){
                    dp[i][j] = 0;
                }
                else{
                    int exe = dp[i-1][j];
                    int inc = 0;
                    
                    int k = i-1;
                    if(j>=wt[k]){
                        inc = dp[i-1][j-wt[k]] + val[k];
                    }
                    dp[i][j] = Math.max(inc, exe);
                }
            }
        }
        System.out.println(dp[n][cap]);
        print(dp, val, wt);
 }
    
    
    public static class Pair{
        int i, j; String psf;
        Pair(int i , int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    public static void print(int[][]dp, int[]val, int[]wt){
        int n = val.length;
        int cap = dp[0].length-1;
        
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(n, cap, " "));
        
        while(que.size()!=0){
            Pair rem = que.remove();
            int i = rem.i;
            int j = rem.j;
            String psf = rem.psf;
            
             if(i==0 || j==0){
                System.out.println(psf);
                continue;
            }
            
            int exe = dp[i-1][j];
            int inc = 0;
            
            int k = i-1;
            if(j>=wt[k]){
                inc = val[k] + dp[i-1][j-wt[k]];
            }
            
            if(dp[i][j]==exe){
                que.add(new Pair(i-1, j, psf));
            }
            if(dp[i][j]==inc){
                if(j>=wt[k]){
                    que.add(new Pair(i-1, j-wt[k], k+" "+psf));
                }
            }
        }
    }
    