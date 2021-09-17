class Solution {
    public int splitArray(int[] nums, int m) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        
        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }
        int ans = high;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(sol(nums, n, mid, m)==false){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    
    public boolean sol(int arr[], int n, int limit, int m){
        int count = 1;
        int sum = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i]>limit){
                return false;
            }
            if(sum+arr[i]>limit){
                count++;
                sum = arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return count<=m;
    }
}