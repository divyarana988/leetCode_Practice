class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int low = 1;
        int high = 0;
        int n = arr.length;
        for(int num : arr){
            high = Math.max(num, high);
        }
        
        int ans = high;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(sol(arr, n, mid)<=threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public int sol(int arr[], int n, int div){
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += (arr[i]/div);
            
            if(arr[i]%div!=0){
                sum+=1;
            }
        }
        return sum;
    }
}