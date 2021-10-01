public static void Solution(int a[]){
        // write your code here
        int n = a.length;
        int[]dp = new int[n];
        dp[n-1] = 0;
        
        for(int i= n-2; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=a[i] && i+j<n; j++){
                if(dp[i+j]<min){
                    min = dp[i+j];
                }
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = min;
            }else{
                dp[i] = min+1;
            }
        }
        System.out.println(dp[0]);
        print(a, dp);
    }
    
    public static void print(int[]a, int dp[]){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        int n = a.length;
        
        que.add(new Pair(0, "0"));
        
        while(que.size()>0){
            Pair rem = que.remove();
            if(rem.i == n-1){
                System.out.println(rem.psf+" .");
                continue;
            }
            for(int j=1; j<=a[rem.i] && rem.i+j<n; j++){
                if(dp[rem.i+j] == dp[rem.i]-1){
                    que.add(new Pair(rem.i+j, rem.psf+ " -> " + (rem.i+j)));
                }
            }
        }
    }
    
    public static class Pair{
        int i; String psf;
        Pair(int i, String psf){
            this.i = i;
            this.psf = psf;
        }
    }