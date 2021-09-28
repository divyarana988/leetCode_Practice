public static int sol(int[]arr){
    int[]dp = new int[arr.length];
    int omax  0;

    for(int i=0; i<arr.length; i++){
        int max = 0;
        for(int j=0; j<i; j++){
            if(arr[j]<arr[i]){
                max = Math.max(dp[j], max);
            }
        }
        dp[i] = max + arr[i];
        omax = Math.max(dp[i], omax);
    }
    return omax;
}