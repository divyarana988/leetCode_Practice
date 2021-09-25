class Solution
{
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[]arr = new Box[3*n];
        int k=0;
        
        for(int i=0; i<n; i++){
            int a = length[i];
            int b = width[i];
            int c = height[i];
            
            if(a<b){
                arr[k] = new Box(b,a,c);
            }else
                arr[k] = new Box(a,b,c);
            k++;
            
            if(b<c)
                arr[k] = new Box(c,b,a);
            else
                arr[k] = new Box(b,c,a);
            k++;
            
            if(a<c)
                arr[k] = new Box(c,a,b);
            else
                arr[k] = new Box(a,c,b);
            k++;    
        }
        
        Arrays.sort(arr);
        int maxH = 0;
        int[]dp = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            int max =0;
            for(int j=0; j<i; j++){
                if(arr[j].l<arr[i].l && arr[j].w<arr[i].w)
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + arr[i].h;
            maxH = Math.max(maxH, dp[i]);
        }
        return maxH;
    }
    static class Box implements Comparable<Box>{
        int l, w, h;
        Box(){
            
        }
        Box(int l, int w, int h){
            this.l = l;
            this.w = w;
            this.h = h;
        }
        public int compareTo(Box o){
            int ta = this.l*this.w;
            int oa = o.l*o.w;
            return ta - oa;
        }
    }
}