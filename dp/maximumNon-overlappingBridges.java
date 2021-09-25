
      public static class Bridge implements Comparable<Bridge>{
        int nc, sc;
        Bridge(){
            
        }
        Bridge(int nc, int sc){
            this.nc = nc;
            this.sc = sc;
        }
        public int compareTo(Bridge o){
            if(this.nc==o.nc)
                return this.sc-o.sc;
            else
                return this.nc-o.nc;
        }
    }
   
	public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Bridge[] ar = new Bridge[n];
        
        for(int i=0; i<n;i++){
            int nc = scn.nextInt();
            int sc = scn.nextInt();
            ar[i] = new Bridge(nc, sc);
            
        }
        int count = solve(ar);
        System.out.println(count);
	}
    
    public static int solve(Bridge []arr){
        Arrays.sort(arr);
        int omax = 0;
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[j].sc<arr[i].sc && arr[j].nc<arr[i].nc){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }