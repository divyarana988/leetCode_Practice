public int solve(int[][]arr){
    Arrays.sort(arr, (a,b)->{
        if(a[0]==b[0])
            return a[1]-b[1];
        else
            return a[0]-b[0];    
    });

    int omax = 0;
    int[]dp = new int[arr.length];

    for(int i =0; i<arr.length; i++){
        int max=0;
        for(int j=0; j<i; j++){
            if(arr[j][1]<arr[i][1] && arr[j][0]<arr[i][0])
                max = Math.max(max, dp[j]);
        }
        dp[i] = max + 1;
        omax = Math.max(omax, dp[i]);
    }
    return omax;
}