class Solution {
    int max =0;
    public int getMaximumGold(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
       int max = Integer.MIN_VALUE;
        for(int i=0 ;i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]!=0){
                    max = Math.max(max, helper(arr, m, n, i, j ));
                }
            }
        }
        return max;
    }
    
    public static int helper(int[][]arr, int m, int n, int i, int j){
        if(i < 0 || i == m || j < 0 || j == n || arr[i][j] == 0){
            return 0;
        }
        int val = arr[i][j];
        arr[i][j] = 0 ;
        int a = helper(arr, m, n, i-1, j);
        int b = helper(arr, m, n, i, j+1);
        int c = helper(arr, m, n, i, j-1);
        int d = helper(arr, m, n, i+1, j);
        arr[i][j] = val;
        return Math.max(Math.max(a,b), Math.max(c,d))+val;
    }
}
