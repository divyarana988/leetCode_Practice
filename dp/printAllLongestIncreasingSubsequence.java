public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []a){
// write your code here
    int n = a.length;
    int[] dp = new int[n];
    int omax = 0;
    
    for(int i=0; i<n; i++){
        int max = 0;
        for(int j=0; j<i; j++){
            if(a[j]<a[i]){
                max = Math.max(max, dp[j]);
            }
        }
        dp[i] = max + 1;
        omax = Math.max(dp[i], omax);
    }
    System.out.println(omax);
    print(a, dp, omax);
    }
    
    public static void print(int[] a, int[] dp, int omax){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        for(int i=0; i<dp.length; i++){
            if(dp[i] == omax){
                que.add(new Pair(dp[i], i, a[i], a[i] +""));
            }
        }
        while(que.size()>0){
            Pair rem = que.remove();
            if(rem.l == 1){
                System.out.println(rem.psf);
                continue;
            }
            for(int j= rem.i-1; j>=0; j--){
                if(a[j]<a[rem.i] && dp[j]==dp[rem.i]-1){
                    que.add(new Pair(dp[j], j, a[j], a[j]+" -> " + rem.psf));
                }
            }
        }
    }
    