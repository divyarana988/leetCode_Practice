class Solution {
    
    public class Pair implements Comparable<Pair>{
        int prime, ptr, val;
        
        public Pair(int prime, int ptr, int val){
            this.prime = prime;
            this.ptr = ptr;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int k=0; k<primes.length; k++){
            pq.add(new Pair(primes[k], 1, primes[k]));
        }
        
        dp[1] = 1;
        
        for(int i=2; i<=n;){
            Pair rem = pq.remove();
            
            if(dp[i-1]!=rem.val){
                dp[i] = rem.val;
                i++;
            }
            int nptr = rem.ptr + 1;
            int nval = rem.prime * dp[rem.ptr];
            pq.add(new Pair(rem.prime, nptr, nval));
        }
        return dp[n];
    }
}