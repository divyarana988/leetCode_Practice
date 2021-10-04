class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int len = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<len; i++){
            mp.put(nums[i], i);
        }
        Arrays.sort(nums);
        boolean[] vis = new boolean[len];
        Arrays.fill(vis, false);
        
        int ans = 0;
        
        for(int i=0; i<len; i++){
            if(vis[i] || mp.get(nums[i])==i){
                continue;
            }
            int j = i;
            int size = 0;
            
            while(!vis[j]){
                vis[j] = true;
                j = mp.get(nums[j]);
                size++;
            }
            if(size>0){
                ans += size-1;
            }
        }
        return ans;
    }
}