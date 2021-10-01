class Solution
{
    //Function to get the maximum total value in the knapsack.
    static class Pair implements Comparable <Pair>{
        int wt, val;
        double r;
        
        
        Pair(int wt, int val){
            this.wt = wt;
            this.val = val;
            this.r = (val*1.0)/wt;
        }
        public int compareTo(Pair o){
            if(this.r<o.r){
                return -1;
            }
            else if(this.r>o.r){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Pair[]a = new Pair[n];
        for(int i=0; i<n; i++){
            Pair p = new Pair(arr[i].weight, arr[i].value);
            a[i] = p;
        }
        Arrays.sort(a);
        int remCap = W;
        double profit = 0.0;
        
        for(int i=n-1; i>=0; i--){
            Pair p = a[i];
            
            if(p.wt<=remCap){
                remCap -= p.wt;
                profit += p.val;
            }
            else{
                profit += (p.r*remCap);
                remCap = 0;
                break;
            }
        }
        return profit;
    }
}